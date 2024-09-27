Attribute VB_Name = "BulkRename"
Option Explicit

' Bulk Rename the Variable Names in a .Java and .Form file
Sub BulkRename()
    
    ' open the file to be read
    Dim fileNum As Integer
    fileNum = FreeFile
    ' get the file name from the user using browse dialog
    Dim fileName As String
    fileName = Application.GetOpenFilename("Java Files (*.java), *.java")
    If fileName = "False" Then
        Exit Sub
    End If

    ' read the file and rename the variables
    Dim line As String
    Dim newLine As String
    Dim oldVar As String
    Dim newVar As String
    Dim VarNameTbl As ListObject
    Set VarNameTbl = ThisWorkbook.Sheets("Sheet1").ListObjects("VarNameTbl")

    Dim oldVarCol As Range
    
    On Error Resume Next
    Set oldVarCol = VarNameTbl.ListColumns("Old").DataBodyRange
    On Error GoTo 0
    
    If oldVarCol Is Nothing Then
        MsgBox "The column 'Old' does not exist in the table VarNameTbl.", vbExclamation
    End If

    Dim newVarCol As Range
    
    On Error Resume Next
    Set newVarCol = VarNameTbl.ListColumns("New").DataBodyRange
    On Error GoTo 0
    
    If oldVarCol Is Nothing Then
        MsgBox "The column 'New' does not exist in the table VarNameTbl.", vbExclamation
    End If

    Open fileName For Input As #fileNum

    ' get the Variable Name from the file and it is the last word in the swntence similar to private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    ' so we need to get the last word in the sentence
    ' add the variable name to the table VarNameTbl to the Old Column

    ' read the file line by line
    ' end the loop when the // End of variables declaration is reached do not read that line
    Dim startReading As Boolean
    startReading = False
    
    Do While Not EOF(fileNum)
    Line Input #fileNum, line
        
        If InStr(line, "// Variables declaration") > 0 Then
            startReading = True
        End If
        
        If startReading Then
            If InStr(line, "// End of variables declaration") > 0 Then
                Exit Do
            End If
            
            ' get the variable name
            oldVar = getVariableName(line)
            
            ' remove any semicolons from oldVar
            oldVar = Replace(oldVar, ";", "")
            
            'IF the table has reached the end of the list then add a new row
            If oldVarCol.Cells(oldVarCol.Rows.Count, 1).End(xlUp).Row = oldVarCol.Rows.Count Then
                oldVarCol.ListObject.ListRows.Add
            End If
            
            ' add the variable name to the table VarNameTbl to the Old Column
            oldVarCol.Cells(oldVarCol.Rows.Count, 1).End(xlUp).Offset(1, 0).Value = oldVar
        End If
    Loop

    ' Close the file
    Close #fileNum

    ' add the FileDirectoy to FileName range in the sheet without .java
    ThisWorkbook.Sheets("Sheet1").Range("FileName").Value = fileName

    ' remove the .java from the file name
    fileName = Left(fileName, Len(fileName) - 5)
End Sub

Function getVariableName(line As String) As String
    Dim words() As String
    words = Split(line, " ")
    getVariableName = words(UBound(words))
End Function

Sub ReplaceAllInFile(filePath As String, findText As String, replaceText As String)
    Dim fileNum As Integer
    Dim fileContent As String
    Dim backupFilePath As string
    
    ' Copy the original file to the backup file
    FileCopy filePath, backupFilePath
    
    ' Open the original file for reading
    fileNum = FreeFile
    Open filePath For Input As #fileNum
    
    ' Read the entire content of the file into a string variable
    fileContent = Input$(LOF(fileNum), fileNum)
    
    ' Close the file
    Close #fileNum
    
    ' Perform the replacement operation
    fileContent = Replace(fileContent, findText, replaceText)
    
    ' Open the original file for writing
    fileNum = FreeFile
    Open filePath For Output As #fileNum
    
    ' Write the modified content back to the original file
    Print #fileNum, fileContent
    
    ' Close the file
    Close #fileNum
End Sub

Sub RenameVariables()
    Dim VarNameTbl As ListObject
    Dim oldVarCol As ListColumn
    Dim newVarCol As ListColumn
    Dim i As Long
    Dim oldVar As String
    Dim newVar As String
    Dim fileName As String
    
    ' Get a reference to the VarNameTbl table
    Set VarNameTbl = ThisWorkbook.Sheets("Sheet1").ListObjects("VarNameTbl")

    call Backup(fileName)
    
    ' Get references to the Old and New columns
    Set oldVarCol = VarNameTbl.ListColumns("Old")
    Set newVarCol = VarNameTbl.ListColumns("New")
    
    ' Get the file name from the FileName range
    fileName = ThisWorkbook.Sheets("Sheet1").Range("FileName").Value

    ' create a backup for the Form file abd the Java file
    Dim backupFilePath As String
    
    ' Loop through each row in the table
    For i = 1 To oldVarCol.DataBodyRange.Rows.Count
        ' Get the old and new variable names
        oldVar = oldVarCol.DataBodyRange.Cells(i, 1).Value
        newVar = newVarCol.DataBodyRange.Cells(i, 1).Value

        ' Check if newVar is not empty
        If newVar <> "" Then
            ' Replace all occurrences of the old variable name with the new variable name in the file
            fileName = ThisWorkbook.Sheets("Sheet1").Range("FileName").Value
            fileName = fileName & ".java"
            
            
            ' Replace all occurrences of the old variable name with the new variable name in the file
            ReplaceAllInFile fileName, oldVar, newVar

            ' Replace .java with .form
            fileName = Replace(fileName, ".java", ".form")
            ReplaceAllInFile fileName, oldVar, newVar

        End If
    Next i
End Sub

Sub Backup (fileName)
    Dim backupFileName As String
    
    ' Get the file name from the FileName range
    fileName = ThisWorkbook.Sheets("Sheet1").Range("FileName").Value
    fileName = fileName & ".java"
    backupFileName = fileName & ".bak"
    FileCopy fileName, backupFileName

    fileName = Replace(fileName, ".java", ".form")
    backupFileName = fileName & ".bak"
    FileCopy fileName, backupFileName


End Sub


