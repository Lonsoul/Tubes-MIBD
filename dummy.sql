-- DROP TABLES in the correct order to avoid foreign key errors
DROP TABLE IF EXISTS PublicVideoWatch;
DROP TABLE IF EXISTS UserKanalSubscribe;
DROP TABLE IF EXISTS CreatorMemilikiKanal;
DROP TABLE IF EXISTS Video;
DROP TABLE IF EXISTS Grup;
DROP TABLE IF EXISTS Individu;
DROP TABLE IF EXISTS Kanal;
DROP TABLE IF EXISTS Creator;
DROP TABLE IF EXISTS [Public];
DROP TABLE IF EXISTS [User];

-- TABEL UTAMA
CREATE TABLE [User] (
    User_Id INT PRIMARY KEY,
    Email VARCHAR(100),
    Password VARCHAR(100),
    Nama_User VARCHAR(100),
    Status_User VARCHAR(50)
);

CREATE TABLE [Public] (
    User_Id INT PRIMARY KEY,
    Liked_Vid VARCHAR(255),
    SubscribedList VARCHAR(255),
    FOREIGN KEY (User_Id) REFERENCES [User](User_Id)
);

CREATE TABLE Creator (
    User_Id INT PRIMARY KEY,
    FOREIGN KEY (User_Id) REFERENCES [User](User_Id)
);

CREATE TABLE Kanal (
    Id_Kanal INT PRIMARY KEY,
    Deskripsi_Kanal TEXT,
    Nama_Kanal VARCHAR(100),
    Status_Kanal VARCHAR(50),
    Url_Kanal VARCHAR(255)
);

CREATE TABLE Individu (
    Id_Individu INT PRIMARY KEY,
    FOREIGN KEY (Id_Individu) REFERENCES Creator(User_Id)
);

CREATE TABLE Grup (
    Id_Grup INT PRIMARY KEY,
    Nama_Grup VARCHAR(100),
    Jenis_Role VARCHAR(100)
);

CREATE TABLE Video (
    Id_Video INT PRIMARY KEY,
    Title VARCHAR(255),
    Subtitle VARCHAR(255),
    Url_Video VARCHAR(255),
    DurasiVideo VARCHAR(10),
    Deskripsi_Vid TEXT,
    Status_Vid VARCHAR(50),
    Id_Individu INT,
    FOREIGN KEY (Id_Individu) REFERENCES Individu(Id_Individu)
);

CREATE TABLE CreatorMemilikiKanal (
    User_Id INT,
    Id_Kanal INT,
    PRIMARY KEY (User_Id, Id_Kanal),
    FOREIGN KEY (User_Id) REFERENCES Creator(User_Id),
    FOREIGN KEY (Id_Kanal) REFERENCES Kanal(Id_Kanal)
);

CREATE TABLE UserKanalSubscribe (
    User_Id INT,
    Id_Kanal INT,
    Subscribe VARCHAR(10),
    PRIMARY KEY (User_Id, Id_Kanal),
    FOREIGN KEY (User_Id) REFERENCES [User](User_Id),
    FOREIGN KEY (Id_Kanal) REFERENCES Kanal(Id_Kanal)
);

CREATE TABLE PublicVideoWatch (
    User_Id INT,
    Id_Video INT,
    Dislike INT,
    Liked INT,
    Comment TEXT,
    AwalVid VARCHAR(10),
    AkhirVid VARCHAR(10),
    Approve VARCHAR(10),
    PRIMARY KEY (User_Id, Id_Video),
    FOREIGN KEY (User_Id) REFERENCES [Public](User_Id),
    FOREIGN KEY (Id_Video) REFERENCES Video(Id_Video)
);

-- DUMMY DATA
INSERT INTO [User] (User_Id, Email, Password, Nama_User, Status_User) VALUES
(1, 'alice@gmail.com', 'pass123', 'Alice', 'Public'),
(2, 'bob@gmail.com', 'pass456', 'Bob', 'Creator'),
(3, 'carol@gmail.com', 'pass789', 'Carol', 'Creator');

INSERT INTO [Public] (User_Id, Liked_Vid, SubscribedList) VALUES
(1, '1,2', '1'),
(3, '2', '2,3');

INSERT INTO Creator (User_Id) VALUES
(2),
(3);

INSERT INTO Kanal (Id_Kanal, Deskripsi_Kanal, Nama_Kanal, Status_Kanal, Url_Kanal) VALUES
(1, 'Tech Channel', 'TechTalk', 'Aktif', 'youtube.com/techtalk'),
(2, 'Daily Vlogs', 'LifeVlog', 'Aktif', 'youtube.com/lifevlog');

INSERT INTO Individu (Id_Individu) VALUES
(2),
(3);

INSERT INTO Grup (Id_Grup, Nama_Grup, Jenis_Role) VALUES
(1, 'TechTeam', 'Editor'),
(2, 'VlogCrew', 'Camera');

INSERT INTO Video (Id_Video, Title, Subtitle, Url_Video, DurasiVideo, Deskripsi_Vid, Status_Vid, Id_Individu) VALUES
(1, 'Intro to AI', 'Basics of AI', 'youtu.be/ai123', '10:00', 'Explains AI basics', 'Published', 2),
(2, 'My Daily Routine', 'Morning to night', 'youtu.be/vlog456', '15:30', 'Vlog of daily activities', 'Published', 3);

INSERT INTO CreatorMemilikiKanal (User_Id, Id_Kanal) VALUES
(2, 1),
(3, 2);

INSERT INTO UserKanalSubscribe (User_Id, Id_Kanal, Subscribe) VALUES
(1, 1, 'Yes'),
(1, 2, 'Yes');

INSERT INTO PublicVideoWatch (User_Id, Id_Video, Dislike, Liked, Comment, AwalVid, AkhirVid, Approve) VALUES
(1, 1, 0, 1, 'Great video!', '00:00', '10:00', 'Yes'),
(1, 2, 0, 1, 'Very inspiring', '00:00', '15:30', 'Yes');
