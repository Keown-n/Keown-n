CREATE TABLE IF NOT EXISTS  Atterberg_Info(
	Sample_No VARCHAR(10),
	Atterberg_No VARCHAR(10),
	Tester VARCHAR(100),
	Calibration_Plate VARCHAR(50),
	Liquid_Limit_Cup VARCHAR(50),
	Balance VARCHAR(50),
	Spatula VARCHAR(50),
	Grooving_Tool VARCHAR(50),
	Rod_3mm VARCHAR(50),
	Sieve_425um BOOLEAN,
	MassOfFines FLOAT,
	TroughSerialNo VARCHAR(50),
	
	TinL INT,
	TinP INT,
	LinearShrinkage_mm FLOAT,

	PRIMARY KEY (Atterberg_No)
);

CREATE TABLE IF NOT EXISTS  Atterberg_PointL(
	Atterberg_No VARCHAR(10),
	TinL INT,
	MoistMass FLOAT,
	DryMass FLOAT,
	taps INT,

	PRIMARY KEY (Atterberg_No, TinL)
);



CREATE TABLE IF NOT EXISTS  Atterberg_PointP(
	Atterberg_No VARCHAR(10),
	TinP INT,
	MoistMass FLOAT,
	DryMass FLOAT,

	PRIMARY KEY (Atterberg_No, TinP)
);

-- ADD FOREIGN KEY (Atterberg_No) REFERENCES Atterberg_Info(Atterberg_No);

CREATE TABLE IF NOT EXISTS  Join_AtterbergTin (
	Atterberg_No VARCHAR(10),
	TinL INT,
	TinP INT,

	PRIMARY KEY (Atterberg_No, TinL, TinP)
);


CREATE TABLE IF NOT EXISTS  Atterberg_Tin_Cal (
	Date_Recorded DATE,
	Frequency_days INT,
	Next_Date DATE,
	NumTins INT,
	TinDet_ID INT,
	PRIMARY KEY (TinDet_ID)
);

CREATE TABLE IF NOT EXISTS  Atterberg_Tin_Data (
	TinDet_ID INT,
	TinNo VARCHAR(5),
	Mass INT,
	PRIMARY KEY (TinDet_ID, TinNo)
);

ALTER TABLE Atterberg_Tin_Data
ADD FOREIGN KEY (TinDet_ID) REFERENCES Atterberg_Tin_Cal(TinDet_ID);


CREATE TABLE IF NOT EXISTS  Join_AtterbergTinData (
	TinDet_ID INT,
	Atterberg_No VARCHAR(10),
	TinL INT,
	TinP INT,

	PRIMARY KEY (TinDet_ID, Atterberg_No, TinL, TinP)
);




CREATE TABLE IF NOT EXISTS  branch (
	BranchName VARCHAR(100),
	TmhCbr BOOLEAN,
	PhyAddr1 VARCHAR(100),
	PhyAddr2 VARCHAR(100),
	PostAddr VARCHAR(100),
	TelNo VARCHAR(20),
	FaxNo VARCHAR(20),
	Mobile VARCHAR(20),
	EmailAdd VARCHAR(100),
	Web VARCHAR(100),
	CertType VARCHAR(50),
	CertNo VARCHAR(50),
	ManName VARCHAR(100),
	SpStr20 VARCHAR(20),
	SpInt INT,
	SpFloat FLOAT,
	SpBool BOOLEAN,
	TechName VARCHAR(100),
	BranchTable VARCHAR(100),
	Sample_NO VARCHAR(50)
);

-- Technical signatory table optimized with VARCHAR size adjustments and SampleID renamed to Sample_NO
CREATE TABLE IF NOT EXISTS  techsign (
	EmplyNo VARCHAR(50),
	TechName VARCHAR(100),
	TechTitle VARCHAR(100),
	TechQual VARCHAR(100),
	Sample_NO VARCHAR(100),
    PRIMARY KEY (EmplyNo)
);

-- Corrected SQL script with syntax fixes and order for table creation considering dependencies

-- First, CREATE TABLE IF NOT EXISTS s without foreign key dependencies

CREATE TABLE IF NOT EXISTS  CBR_Compaction_Data (
	Sample_NO VARCHAR(10),
	CBR_No VARCHAR(10),

	-- swell data
	Swell_Tester VARCHAR(100),
	Swell_Date_in_water DATE,
	Swell_Time_in_water TIME,
	Swell_Dial_Gauge VARCHAR(50),
	Swell_Tripod VARCHAR(50),

	-- penetration data
	Penetration_Tester VARCHAR(100),
	Penetration_Date DATE,
	Penetration_Time TIME,
	Penetration_Surcharge VARCHAR(50),
	Penetration_Piston VARCHAR(50),
	CBR_Press VARCHAR(50),

	-- compaction Equipment Data
	Compaction_Tester VARCHAR(100),
	Date_Compacted DATE,
	Measuring_Cylinder VARCHAR(50),
	Mixing_Bath VARCHAR(50),
	Base_Plate VARCHAR(50),
	Collar VARCHAR(50),
	Depth_Gauge VARCHAR(50),
	Compaction_Hammer VARCHAR(50),
	Straight_Edge_No_1 VARCHAR(50),
	Straight_Edge_No_2 VARCHAR(50),
	Balance VARCHAR(50),
	Time_Measuring_Device VARCHAR(50),

	-- Hygro Moisture Data
	Hygro_Tester VARCHAR(100),
	Hygro_Date DATE,
	Hygro_Oven VARCHAR(50),
	Hygro_Balans VARCHAR(50),

	PRIMARY KEY (CBR_No)
);

CREATE TABLE IF NOT EXISTS  CBR_Mould_Calibration (
	Date_Recorded DATE,
	Frequency_days INT,
	Next_Date DATE,
	NumMoulds INT,
	CBR_DET_ID INT,
	PRIMARY KEY (CBR_DET_ID)
);

CREATE TABLE IF NOT EXISTS  CbrMouldDet (
	Mass INT,
	MouldNo VARCHAR(10),
	Volume INT,
	PRIMARY KEY (MouldNo)
);

-- Then, CREATE TABLE IF NOT EXISTS s with foreign key dependencies

CREATE TABLE IF NOT EXISTS  Compaction_Effort (
	CBR_No VARCHAR(10),
	MouldNo VARCHAR(10),
	PerforatedPlate VARCHAR(100),
	MassMouldSoil FLOAT,
	SpecimenLinkID INT,
	PRIMARY KEY (CBR_No, MouldNo)
);



CREATE TABLE IF NOT EXISTS  CBR_SWELL (
	CBR_No VARCHAR(10),
	MouldNo VARCHAR(10),
	Initial DECIMAL(10,2),
	hr24 DECIMAL(10,2),
	hr96 DECIMAL(10,2),
	CustomHours DECIMAL(10,2),
	PercentageSwell DECIMAL(10,2),
	PRIMARY KEY (CBR_No, MouldNo)
);



CREATE TABLE IF NOT EXISTS  HygroCalculations (
	CBR_No VARCHAR(10),
	TinNo INT(11),
	MassMoist FLOAT,
	MassDry FLOAT,
	PRIMARY KEY (CBR_No, TinNo)
);


CREATE TABLE IF NOT EXISTS  RemouldMoisture (
	CBR_No VARCHAR(10),
	TinNo INT(11),
	MassMoist FLOAT,
	MassDry FLOAT,
	PRIMARY KEY (CBR_No, TinNo)
);

CREATE TABLE IF NOT EXISTS  Penetration (
	CBR_No VARCHAR(10),
	MouldNo VARCHAR(10),
	SpecimenLinkID INT,
	Penetration FLOAT,
	PRIMARY KEY (CBR_No, MouldNo)
);

CREATE TABLE IF NOT EXISTS  CbrMouldJoinTable (
	CBR_DET_ID INT,
	MouldNo VARCHAR(10),
	PRIMARY KEY (CBR_DET_ID, MouldNo)
);
-- First, create ClientAdres without the unnecessary foreign key reference to JobCard
CREATE TABLE IF NOT EXISTS  ClientAdres (
	ClientID VARCHAR(8) PRIMARY KEY,
	CustName VARCHAR(255),
	PostAddr1 VARCHAR(255),
	PostAddr2 VARCHAR(255),
	PostAddr3 VARCHAR(255)
);

-- Then, create JobCard which references ClientAdres
CREATE TABLE IF NOT EXISTS  JobCard (
	JobCardNo VARCHAR(150),
	JobDate DATE,
	Sample_No VARCHAR(255),
	ClientID VARCHAR(8),
	Attention VARCHAR(255),
	ProjectName VARCHAR(255),
	ProjectLocation VARCHAR(255),
	ProjectEngineer VARCHAR(255),
	ProjectContactNo VARCHAR(255),
	TimeRequested TIME,
	TimeDeparture TIME,
	TimeReturn TIME,
	EstimatedTravel FLOAT,
	Technician1 VARCHAR(255),
	Technician2 VARCHAR(255),
	TestingType VARCHAR(255),
	SampledBy VARCHAR(255),
	SamplePlan VARCHAR(255),
	PRIMARY KEY (JobCardNo)
);

-- Link table between JobCard and Sample
CREATE TABLE IF NOT EXISTS  JobCard_Sample (
	JobCardNo VARCHAR(150),
	Sample_No VARCHAR(10),
	PRIMARY KEY (JobCardNo, Sample_No)
);


CREATE TABLE IF NOT EXISTS  MOD_Test (
	Sample_No VARCHAR(10),
	MOD_No VARCHAR(10),
	Ave_Hyg FLOAT,
	UseAveH BOOLEAN,
	Calculated FLOAT,
	OMC FLOAT,
	MDD FLOAT,
	NumPoints INT,
	MODmould VARCHAR(255),

	-- stabilized soil?
	Stabilized BOOLEAN,
	Stabilizer VARCHAR(255),
	StabilizerPercentage FLOAT,
	StabilizerRemarks VARCHAR(255),


	MoistureTester VARCHAR(255),
	MoistureDate DATE,
	MoistureBalance VARCHAR(255),
	MoistureOven VARCHAR(255),

	MeasuringCylinder VARCHAR(255),
	CompactionBalance VARCHAR(255),
	CompactionOven VARCHAR(255), 


	CompactionTester VARCHAR(255),
	MixingBath VARCHAR(255),
	BasePlate VARCHAR(255),
	Collar VARCHAR(255),
	DepthGauge VARCHAR(255),
	CompactionHammer VARCHAR(255),
	StraightEdge1 VARCHAR(255),
	StraightEdge2 VARCHAR(255),
	TimeMeasuringDevice VARCHAR(255),

	PRIMARY KEY (MOD_No)
);

-- create a table for the data points
CREATE TABLE IF NOT EXISTS  MODdATA (
	MOD_No VARCHAR(10),
	ModPoint INT,
	-- Density Calculations
	MouldID INT,

	SpecimenSize FLOAT,
	EstimatedMoisture FLOAT,
	WaterAdded FLOAT,
	TimeCompacted TIME,
	MoistMouldMass FLOAT,
	MouldFactor FLOAT,

	-- Moisture Data
	TinID INT,
	MoistMass FLOAT,
	DryMass FLOAT,
	Difference FLOAT,
	PRIMARY KEY (MOD_No, ModPoint)
);

-- CREATE A ModMould Calibration table
CREATE TABLE IF NOT EXISTS  ModMouldCal(
	Date_Recorded DATE,
	Frequency_days INT,
	Next_Date DATE,
	NumMoulds INT,
	MouldDet_ID INT,
	PRIMARY KEY (MouldDet_ID)
);

-- modMouldDetails
CREATE TABLE IF NOT EXISTS  ModMouldData (
	mass FLOAT, 
	ModMouldID INT,
	Volume FLOAT,
	PRIMARY KEY (ModMouldID)
);

-- MoistureTin Calibrations
CREATE TABLE IF NOT EXISTS  MOISTURE_TIN_CAL (
	Date_Recorded DATE,
	Frequency_days INT,
	Next_Date DATE,
	NumTins INT,
	TinDet_ID INT,
	PRIMARY KEY (TinDet_ID)
);
-- MoistureTinRecord
CREATE TABLE IF NOT EXISTS  MOISTURE_TIN_DATA ( 
	TinNo INT, 
	Mass FLOAT, 
	TinDet_ID INT,
	PRIMARY KEY (TinNo)
);
-- Sample Rules
-- Sample can contain one of each test or test group
-- Test Groups are CBR, UCS, Indicator
-- CBR Group contain CBR Table, atterberg table, sieve table, mod table
-- UCS Group contain UCS Table, atterberg Table, sieve Table, Mod Table
-- Indicator group contains atterberg and sieve tables

CREATE TABLE IF NOT EXISTS  Sample(
	Sample_No VARCHAR(10),
	Our_Ref VARCHAR(255),
	Your_Ref VARCHAR(255),
	Date_Rep VARCHAR(255),
	Project VARCHAR(255),
	Compiled_By VARCHAR(255),
	Rep_Head VARCHAR(255),
	-- Test_Method will determine which table to link to
	Test_Method VARCHAR(255),
	Page_No VARCHAR(255),
	DrawSLogo BOOLEAN,
	Container VARCHAR(255),
	Approx_Mass VARCHAR(255),
	MCondition VARCHAR(255),
	Layer_Tested VARCHAR(255),
	MatDescrip VARCHAR(255),
	Hole_No VARCHAR(255),
	Road_No_1 VARCHAR(255),
	Road_No_2 VARCHAR(255),
	Date_Received VARCHAR(255),
	Date_Sampled VARCHAR(255),
	Tested_By VARCHAR(255),
	Client_Mark VARCHAR(255),
	Colour_Type VARCHAR(255),
	Deviation VARCHAR(255),
	Remarks VARCHAR(255),
	-- Test_Method = MOD, Atterberg, UCS, Sieve, CBR
	MOD_No VARCHAR(10),
	Atterberg_No VARCHAR(10),
	UCS_No VARCHAR(10),
	Sieve_No VARCHAR(10),
	CBR_No VARCHAR(10),
	INDICATOR_No VARCHAR(10),
	-- Sample_No is the primary key
	-- sample_no is a foreign key to Atterberg and other tables
	PRIMARY KEY (Sample_No)
);

-- Assuming Test tables (CBR, Atterberg, UCS, Sieve, MOD) are defined elsewhere

-- Join table for CBR Group
CREATE TABLE IF NOT EXISTS  Sample_CBR_Group (
	Sample_No VARCHAR(10),
	CBR_No VARCHAR(10),
	Atterberg_No VARCHAR(10),
	Sieve_No VARCHAR(10),
	MOD_No VARCHAR(10)
);
-- Join table for UCS Group
CREATE TABLE IF NOT EXISTS  Sample_UCS_Group (
	Sample_No VARCHAR(255),
	UCS_No VARCHAR(10),
	Atterberg_No VARCHAR(10),
	Sieve_No VARCHAR(10),
	MOD_No VARCHAR(10)
);

-- Join table for Indicator Group
CREATE TABLE IF NOT EXISTS  Sample_Indicator_Group (
	Sample_No VARCHAR(255),
	Atterberg_No VARCHAR(10),
	Sieve_No VARCHAR(10),
);

-- join table for Sample and MOD_Test
CREATE TABLE IF NOT EXISTS  Sample_MOD (
	Sample_No VARCHAR(10),
	MOD_No VARCHAR(10),
	FOREIGN KEY (Sample_No) REFERENCES Sample(Sample_No),
	FOREIGN KEY (MOD_No) REFERENCES MOD_Test(MOD_No),
	UNIQUE (Sample_No)
);

-- join table for Sample and Atterberg
CREATE TABLE IF NOT EXISTS  Sample_Atterberg (
	Sample_No VARCHAR(10),
	Atterberg_No VARCHAR(10),
	FOREIGN KEY (Sample_No) REFERENCES Sample(Sample_No),
	FOREIGN KEY (Atterberg_No) REFERENCES Atterberg_Info(Atterberg_No),
	UNIQUE (Sample_No)
);

-- join table for Sample and Sieve
CREATE TABLE IF NOT EXISTS  Sample_Sieve (
	Sample_No VARCHAR(10),
	Sieve_No VARCHAR(10),
	FOREIGN KEY (Sample_No) REFERENCES Sample(Sample_No),
	FOREIGN KEY (Sieve_No) REFERENCES SieveAnalysis(Sieve_No),
	UNIQUE (Sample_No)
);



CREATE TABLE IF NOT EXISTS  SieveAnalysis (
	Sieve_No VARCHAR(10),
	Sample_No VARCHAR(10),
	SieveSize VARCHAR(13),
	SampleMass FLOAT,
	LessThanMass FLOAT,
	LessThanMassRiffle FLOAT,

	-- Mass Fines Used
	MassFines FLOAT,
	-- Mass Fines After Drying

	MassFinesAfterDrying FLOAT,

	Tester VARCHAR(50),
	BalanceNo VARCHAR(50),
	OvenID VARCHAR(50),
	Pan_No VARCHAR(50),


	Sieve100mmID VARCHAR(50),
	Sieve75mmID VARCHAR(50),
	Sieve50mmID VARCHAR(50),
	Sieve37_5mmID VARCHAR(50),
	Sieve28mmID VARCHAR(50),
	Sieve20mmID VARCHAR(50),
	Sieve14mmID VARCHAR(50),
	Sieve5mmID VARCHAR(50),
	Sieve2mmID VARCHAR(50),
	Sieve_425mmID VARCHAR(50),
	Sieve_075mmID VARCHAR(50),

	PRIMARY KEY (Sieve_No)
);

-- create the sieveArray table to store the sieve data of Mass Retained, Reduced Mass, Percent Retainedd, and Cumulative Percent Passing
CREATE TABLE IF NOT EXISTS  sieveArray (
	Sieve_No VARCHAR(10),
	SieveSize VARCHAR(13),
	MassRetained FLOAT,
	ReducedMass FLOAT,
	PercentRetained FLOAT,
	CumulativePercentPassing FLOAT,
	-- link to the SieveAnalysis table
	PRIMARY KEY (Sieve_No, SieveSize),
	FOREIGN KEY (Sieve_No) REFERENCES SieveAnalysis(Sieve_No)
);


-- rules for UCS_ITS part of the Database
-- a the UCS_Info stores Equipment used per ucs test
-- the UCS_Info connects using the sample number to UCS_ITS table
-- UCS_ITS has 3 records for UCS and 3 records for ITS per Sample Number
-- Each record for UCS and ITS has its own Hyro record connection
-- CREATE TABLE IF NOT EXISTS  for storing basic UCS test information
CREATE TABLE IF NOT EXISTS  UCS_TEST_INFO(
	Sample_NO VARCHAR(10) NOT NULL,
	UCS_No VARCHAR(10),
	Hygro_tester VARCHAR(20),
	Hygro_Date_Sample DATE,
	Hygro_Balans VARCHAR(20),
	Hygro_Oven VARCHAR(20),
	Compact_tester VARCHAR(20),
	Compact_Balance VARCHAR(20),
	Compact_Oven VARCHAR(20),
	Compact_Date_Start DATE,
	Moisture_Cylinder VARCHAR(20),
	Mixing_Bath VARCHAR(20),
	Base_Plate VARCHAR(20),
	Collar VARCHAR(20),
	Depth_Gauge VARCHAR(20),
	Compaction_Hammer VARCHAR(20),
	Straight_Edge_No_1 VARCHAR(20),
	Straight_Edge_No_2 VARCHAR(20),
	compaction_Balance VARCHAR(20),
	Time_Measuring_Deviceq VARCHAR(20),
	UCS_tester VARCHAR(20),
	UCS_Date DATE,
	PresID VARCHAR(20),
	UCS_BREAKING_HEAD VARCHAR(20),
	PROVING_RING VARCHAR(20),
	VERNIER_CALIPER VARCHAR(20),
	hr24oR7Day BOOLEAN,
	TempCure22C VARCHAR(20),
	Cure_date_start DATE,
	Cure_Time_Start TIME,
	Cure_Date_End DATE,
	Cure_Time_End TIME,
	Curing_Water_Bath VARCHAR(20),
	Curing_Oven VARCHAR(20),
	Soak_Tester VARCHAR(20),
	Soak_Date DATE, 
	Soak_Time_in TIME,
	Soak_Time_out TIME,
	Soak_Water_Bath VARCHAR(20),
	Soak_Timer VARCHAR(20),
	PRIMARY KEY(UCS_No)
);

-- CREATE TABLE IF NOT EXISTS  for UCS and ITS test results with 3 records for each per Sample Number
CREATE TABLE IF NOT EXISTS  UCS_ITS(
	UCS_No VARCHAR(10) NOT NULL,
	Record_Type VARCHAR(10) NOT NULL, -- 'UCS' or 'ITS'
	Record_ID INT NOT NULL,

	UCS DECIMAL(10,2),
	ITS DECIMAL(10,2),

	MOULD_NO VARCHAR(5),


	PRIMARY KEY(UCS_No, Record_Type, Record_ID)
);

-- CREATE TABLE IF NOT EXISTS  for Hygro records associated with UCS and ITS records
CREATE TABLE IF NOT EXISTS  Hygro_Records(
	Hygro_ID INT AUTO_INCREMENT PRIMARY KEY,
	UCS_No VARCHAR(10) NOT NULL,
	Record_Type VARCHAR(10) NOT NULL, -- 'UCS' or 'ITS' or 'HYGRO'
	Record_ID INT NOT NULL,
	TinNo INT,
	MassOfWetSoil DECIMAL(10,2),
	MassOfDrySoil DECIMAL(10,2)
);

-- Mould Calibration data
CREATE TABLE IF NOT EXISTS  ucs_mould_cal(
	Date_Recorded Date,
	Frequency_days INT,
	Next_Date DATE,
	NumMoulds INT,
	UDet_ID INT AUTO_INCREMENT,
	PRIMARY KEY (UDet_ID)
);

-- create a table for the mould mass and volume data
CREATE TABLE IF NOT EXISTS  Ucs_Mould_Details (
	Mass INT,
	MOULD_NO VARCHAR(5),
	Volume INT,
	UDet_ID INT,
	primary key (MOULD_NO)
);


-- Recreate the UCS_Point table with the correct foreign key reference
CREATE TABLE IF NOT EXISTS  UCS_Point (
	ID INT PRIMARY KEY,
	TestSpecimenSampleSize DECIMAL(10, 2), -- (g)
	EstimatedMoistureContent DECIMAL(5, 2), -- W.EST (%)
	WaterToAdd DECIMAL(10, 2), -- (ml)
	TimeStartedCompaction DATETIME,
	UCS_No VARCHAR(10) NOT NULL,
	Record_Type VARCHAR(10) NOT NULL,
	Record_ID INT NOT NULL,
);

-- Recreate the UCS_Point table with the correct foreign key reference
CREATE TABLE IF NOT EXISTS  ITS_Point (
	ID INT PRIMARY KEY,
	TestSpecimenSampleSize DECIMAL(10, 2), -- (g)
	EstimatedMoistureContent DECIMAL(5, 2), -- W.EST (%)
	WaterToAdd DECIMAL(10, 2), -- (ml)
	TimeStartedCompaction DATETIME,
	UCS_No VARCHAR(10) NOT NULL,
	Record_Type VARCHAR(10) NOT NULL,
	Record_ID INT NOT NULL
);

CREATE TABLE Disclamer (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	FonSiz INT,
	IsSanLogo BOOLEAN,
	SanStr1 VARCHAR(255),
	SanStr2 VARCHAR(255),
	SanStr3 VARCHAR(255),
	SanStr4 VARCHAR(255),
	SanStr5 VARCHAR(255),
	SanStr6 VARCHAR(255),
	NolStr1 VARCHAR(255),
	NolStr2 VARCHAR(255),
	NolStr3 VARCHAR(255),
	NolStr4 VARCHAR(255),
	NolStr5 VARCHAR(255),
	NolStr6 VARCHAR(255),
	SpInt INT,
	SpFlo FLOAT,
	Spbool BOOLEAN,
	SpStr VARCHAR(255),
	WIDTH INT,
	CHANGE_LOG TEXT
);

-- alter table statements
ALTER TABLE Atterberg_PointL
ADD FOREIGN KEY (Atterberg_No) REFERENCES Atterberg_Info(Atterberg_No);

alter table Atterberg_PointP
ADD FOREIGN KEY (Atterberg_No) REFERENCES Atterberg_Info(Atterberg_No);

ALTER TABLE Join_AtterbergTin
ADD FOREIGN KEY (Atterberg_No) REFERENCES Atterberg_Info(Atterberg_No), 
ADD FOREIGN KEY (Atterberg_No, TinL) REFERENCES Atterberg_PointL(Atterberg_No, TinL),
ADD FOREIGN KEY (Atterberg_No, TinP) REFERENCES Atterberg_PointP(Atterberg_No, TinP);

ALTER TABLE Atterberg_Tin_Data  
ADD FOREIGN KEY (TinDet_ID) REFERENCES Atterberg_Tin_Cal(TinDet_ID);

ALTER TABLE Join_AtterbergTinData
ADD FOREIGN KEY (TinDet_ID) REFERENCES Atterberg_Tin_Data(TinDet_ID),
ADD FOREIGN KEY (Atterberg_No) REFERENCES Atterberg_Info(Atterberg_No),
ADD FOREIGN KEY (Atterberg_No, TinL) REFERENCES Atterberg_PointL(Atterberg_No, TinL),
ADD FOREIGN KEY (Atterberg_No, TinP) REFERENCES Atterberg_PointP(Atterberg_No, TinP);

ALTER TABLE Compaction_Effort
ADD FOREIGN KEY (CBR_No) REFERENCES CBR_Compaction_Data(CBR_No);

ALTER TABLE CBR_SWELL
ADD FOREIGN KEY (CBR_No) REFERENCES CBR_Compaction_Data(CBR_No);

ALTER TABLE HygroCalculations
ADD FOREIGN KEY (CBR_No) REFERENCES CBR_Compaction_Data(CBR_No),
ADD FOREIGN KEY (TinNo) REFERENCES moisture_tin_data(TinNo);

ALTER TABLE RemouldMoisture
ADD FOREIGN KEY (CBR_No) REFERENCES CBR_Compaction_Data(CBR_No),
ADD FOREIGN KEY (TinNo) REFERENCES moisture_tin_data(TinNo);

ALTER TABLE Penetration
ADD FOREIGN KEY (CBR_No) REFERENCES CBR_Compaction_Data(CBR_No);

ALTER TABLE CbrMouldJoinTable
ADD FOREIGN KEY (CBR_DET_ID) REFERENCES CBR_Mould_Calibration(CBR_DET_ID),
ADD FOREIGN KEY (MouldNo) REFERENCES CbrMouldDet(MouldNo);

ALTER TABLE JobCard
ADD FOREIGN KEY (ClientID) REFERENCES ClientAdres(ClientID);

ALTER TABLE JobCard_Sample
ADD FOREIGN KEY (JobCardNo) REFERENCES JobCard(JobCardNo),
ADD FOREIGN KEY (Sample_No) REFERENCES Sample(Sample_No);

ALTER TABLE MODdATA 
ADD FOREIGN KEY (MOD_No) REFERENCES MOD_Test(MOD_No),
ADD FOREIGN KEY (TinID) REFERENCES moisture_tin_data(TinNo);

ALTER TABLE ModMouldData
ADD FOREIGN KEY (ModMouldID) REFERENCES ModMouldCal(MouldDet_ID);

ALTER TABLE MOD_Test
ADD FOREIGN KEY (ModMouldID) REFERENCES ModMouldData(ModMouldID);

ALTER TABLE MOISTURE_TIN_DATA
ADD FOREIGN KEY (TinDet_ID) REFERENCES MOISTURE_TIN_CAL(TinDet_ID);

ALTER TABLE Sample_CBR_Group
ADD FOREIGN KEY (Sample_No) REFERENCES Sample(Sample_No),
ADD FOREIGN KEY (CBR_No) REFERENCES CBR_Compaction_Data(CBR_No),
ADD FOREIGN KEY (Atterberg_No) REFERENCES Atterberg_Info(Atterberg_No),
ADD FOREIGN KEY (Sieve_No) REFERENCES SieveAnalysis(Sieve_No),
ADD FOREIGN KEY (MOD_No) REFERENCES MOD_Test(MOD_No),
ADD UNIQUE (Sample_No);

ALTER TABLE Join_AtterbergTin
ADD FOREIGN KEY (Atterberg_No) REFERENCES Atterberg_Info(Atterberg_No),
ADD FOREIGN KEY (Atterberg_No, TinL) REFERENCES Atterberg_PointL(Atterberg_No, TinL),
ADD FOREIGN KEY (Atterberg_No, TinP) REFERENCES Atterberg_PointP(Atterberg_No, TinP);

ALTER TABLE UCS_ITS
ADD FOREIGN KEY(UCS_No) REFERENCES UCS_TEST_INFO(UCS_No),
ADD FOREIGN KEY(MOULD_NO) REFERENCES Ucs_Mould_Details(MOULD_NO);

ALTER TABLE Hygro_Records
ADD FOREIGN KEY(UCS_No, Record_Type, Record_ID) REFERENCES UCS_ITS(UCS_No, Record_Type, Record_ID),
ADD	FOREIGN KEY(TinNo) REFERENCES Moisture_Tin_Data(TinNo);

ALTER TABLE Ucs_Mould_Details
ADD FOREIGN KEY (UDet_ID) REFERENCES ucs_mould_cal(UDet_ID);

ALTER TABLE ITS_Point
ADD FOREIGN KEY (UCS_No, Record_Type, Record_ID) REFERENCES UCS_ITS(UCS_No, Record_Type, Record_ID);MOD_Test


 ALTER TABLE Sample_UCS_Group
 
	ADD FOREIGN KEY (Sample_No) REFERENCES Sample(Sample_No),
	ADD FOREIGN KEY (UCS_No) REFERENCES UCS_TEST_INFO(UCS_No),
	ADD FOREIGN KEY (Atterberg_No) REFERENCES Atterberg_Info(Atterberg_No),
	ADD FOREIGN KEY (Sieve_No) REFERENCES SieveAnalysis(Sieve_No),
	ADD FOREIGN KEY (MOD_No) REFERENCES MOD_Test(MOD_No),
	ADD UNIQUE (Sample_No);

ALTER TABLE Sample_Atterberg
ADD FOREIGN KEY (Sample_No) REFERENCES Sample(Sample_No),
ADD FOREIGN KEY (Atterberg_No) REFERENCES Atterberg_Info(Atterberg_No),
ADD UNIQUE (Sample_No);	

ALTER TABLE Sample_Sieve
ADD FOREIGN KEY (Sample_No) REFERENCES Sample(Sample_No),
ADD FOREIGN KEY (Sieve_No) REFERENCES SieveAnalysis(Sieve_No),
ADD UNIQUE (Sample_No);

ALTER TABLE Sample_MOD
ADD FOREIGN KEY (Sample_No) REFERENCES Sample(Sample_No),
ADD FOREIGN KEY (MOD_No) REFERENCES MOD_Test(MOD_No),
ADD UNIQUE (Sample_No);

ALTER TABLE Sample_Indicator_Group
ADD FOREIGN KEY (Sample_No) REFERENCES Sample(Sample_No),
ADD FOREIGN KEY (Atterberg_No) REFERENCES Atterberg_Info(Atterberg_No),
ADD FOREIGN KEY (Sieve_No) REFERENCES SieveAnalysis(Sieve_No),
ADD UNIQUE (Sample_No);


ALTER TABLE Sample_CBR_Group
ADD FOREIGN KEY (Sample_No) REFERENCES Sample(Sample_No),
ADD FOREIGN KEY (CBR_No) REFERENCES CBR_Compaction_Data(CBR_No),
ADD FOREIGN KEY (Atterberg_No) REFERENCES Atterberg_Info(Atterberg_No),
ADD FOREIGN KEY (Sieve_No) REFERENCES SieveAnalysis(Sieve_No),
ADD FOREIGN KEY (MOD_No) REFERENCES MOD_Test(MOD_No),
ADD UNIQUE (Sample_No);

ALTER TABLE UCS_Point
ADD FOREIGN KEY (UCS_No, Record_Type, Record_ID) REFERENCES UCS_ITS(UCS_No, Record_Type, Record_ID);

ALTER TABLE ITS_Point
ADD FOREIGN KEY (UCS_No, Record_Type, Record_ID) REFERENCES UCS_ITS(UCS_No, Record_Type, Record_ID);

ALTER TABLE UCS_ITS
ADD FOREIGN KEY (UCS_No) REFERENCES UCS_TEST_INFO(UCS_No);

ALTER TABLE Hygro_Records
ADD FOREIGN KEY (UCS_No, Record_Type, Record_ID) REFERENCES UCS_ITS(UCS_No, Record_Type, Record_ID);

ALTER TABLE Ucs_Mould_Details
ADD FOREIGN KEY (UDet_ID) REFERENCES ucs_mould_cal(UDet_ID);

-- ALTER TABLE FOR INDICATOR GROUP	
ALTER TABLE Sample_Indicator_Group
ADD FOREIGN KEY (Sample_No) REFERENCES Sample(Sample_No),
ADD FOREIGN KEY (Atterberg_No) REFERENCES Atterberg_Info(Atterberg_No),
ADD FOREIGN KEY (Sieve_No) REFERENCES SieveAnalysis(Sieve_No),
ADD UNIQUE (Sample_No);

ALTER TABLE Join_AtterbergTinData
ADD FOREIGN KEY (TinDet_ID) REFERENCES Atterberg_Tin_Data(TinDet_ID),
ADD FOREIGN KEY (Atterberg_No) REFERENCES Atterberg_Info(Atterberg_No),
ADD FOREIGN KEY (Atterberg_No, TinL) REFERENCES Atterberg_PointL(Atterberg_No, TinL),
ADD FOREIGN KEY (Atterberg_No, TinP) REFERENCES Atterberg_PointP(Atterberg_No, TinP);

ALTER TABLE ITS_Point
ADD FOREIGN KEY (UCS_No, Record_Type, Record_ID) REFERENCES UCS_ITS(UCS_No, Record_Type, Record_ID);

-- link ucs_mould_cal to Ucs_Mould_Details table one ucs_mould_cal to many Ucs_Mould_Details
ALTER TABLE Ucs_Mould_Details
ADD FOREIGN KEY (UDet_ID) REFERENCES ucs_mould_cal(UDet_ID);

-- hygro records is linked to UCS_ITS table 8 hygro records to 1 UCS_ITS record
-- 3 of the hygro records are for UCS, 3 for ITS, and 2 for hygro
ALTER TABLE Hygro_Records
ADD FOREIGN KEY (UCS_No, Record_Type, Record_ID) REFERENCES UCS_ITS(UCS_No, Record_Type, Record_ID),
ADD FOREIGN KEY (TinNo) REFERENCES Moisture_Tin_Data(TinNo);

