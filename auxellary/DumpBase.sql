USE hazardBase;

CREATE TABLE Role (
  Id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  Name VARCHAR(45)  NOT NULL    ,
PRIMARY KEY(Id));


CREATE TABLE Team (
  Id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  Name VARCHAR(45)  NULL    ,
PRIMARY KEY(Id));


CREATE TABLE Tournament (
  Id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  Name VARCHAR(45)  NULL    ,
PRIMARY KEY(Id));


CREATE TABLE User (
  Id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  Role_Id INTEGER UNSIGNED  NOT NULL  ,
  Login VARCHAR(45)  NOT NULL  ,
  UserPassword VARCHAR(45)  NOT NULL    ,
PRIMARY KEY(Id)  ,
INDEX User_FKIndex1(Role_Id),
  FOREIGN KEY(Role_Id)
    REFERENCES Role(Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);
      

CREATE TABLE Player (
  User_Id INTEGER UNSIGNED  NOT NULL  ,
  Account FLOAT ZEROFILL  NOT NULL    ,
PRIMARY KEY(User_Id)  ,
INDEX Player_FKIndex1(User_Id),
  FOREIGN KEY(User_Id)
    REFERENCES User(Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);
      

CREATE TABLE Tournament_has_Team (
  Tournament_Id INTEGER UNSIGNED  NOT NULL  ,
  Team_Id INTEGER UNSIGNED  NOT NULL    ,
PRIMARY KEY(Tournament_Id, Team_Id)  ,
INDEX Tournament_has_Team_FKIndex1(Tournament_Id)  ,
INDEX Tournament_has_Team_FKIndex2(Team_Id),
  FOREIGN KEY(Tournament_Id)
    REFERENCES Tournament(Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Team_Id)
    REFERENCES Team(Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);


CREATE TABLE Game (
  Id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  Tournament_Id INTEGER UNSIGNED  NOT NULL  ,
  HomeTeam_Id INTEGER UNSIGNED  NOT NULL  ,
  GuestTeam_Id INTEGER UNSIGNED  NOT NULL  ,
  PlayDate DATE  NOT NULL  ,
  Result VARCHAR(45)  NULL    ,
PRIMARY KEY(Id)  ,
INDEX Game_FKIndex2(Tournament_Id),
  FOREIGN KEY(Tournament_Id)
    REFERENCES Tournament(Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);


CREATE TABLE Bet (
  Game_Id INTEGER UNSIGNED  NOT NULL  ,
  HomeLoad FLOAT  NOT NULL  ,
  GuestLoad FLOAT  NOT NULL  ,
  DrawLoad FLOAT  NOT NULL  ,
  Resolved BOOL  NOT NULL    ,
PRIMARY KEY(Game_Id)  ,
INDEX Bet_FKIndex1(Game_Id),
  FOREIGN KEY(Game_Id)
    REFERENCES Game(Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

CREATE TABLE Coupon (
  Id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  Bet_Game_Id INTEGER UNSIGNED  NOT NULL  ,
  Player_User_Id INTEGER UNSIGNED  NOT NULL  ,
  BetCash FLOAT  NOT NULL    ,
PRIMARY KEY(Id)  ,
INDEX Coupon_FKIndex1(Player_User_Id)  ,
INDEX Coupon_FKIndex2(Bet_Game_Id),
  FOREIGN KEY(Player_User_Id)
    REFERENCES Player(User_Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Bet_Game_Id)
    REFERENCES Bet(Game_Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);      

      
ALTER TABLE Game add FOREIGN KEY Game_HomeTeam(HomeTeam_Id) REFERENCES Team(Id)
    , add FOREIGN KEY Game_GuestTeam(GuestTeam_Id) REFERENCES Team(Id);

INSERT INTO Role VALUES (1,'Admin');
INSERT INTO Role VALUES (2,'Player');

INSERT INTO Team VALUES (1,'AS Roma');
INSERT INTO Team VALUES (2,'AC Milan');
INSERT INTO Team VALUES (3,'Torino');
INSERT INTO Team VALUES (4,'Juventus Turyn');

INSERT INTO Tournament VALUES (1,'Serie A');
INSERT INTO Tournament VALUES (2,'Puchar Wloch');

INSERT INTO User VALUES (1,1,'AdminMic','obymas');
INSERT INTO User VALUES (2,2,'PlayerMic','obymas');

INSERT INTO Player VALUES (2,200);

INSERT INTO Tournament_has_Team VALUES (1,1);
INSERT INTO Tournament_has_Team VALUES (1,2);
INSERT INTO Tournament_has_Team VALUES (1,3);
INSERT INTO Tournament_has_Team VALUES (1,4);

INSERT INTO Tournament_has_Team VALUES (2,1);
INSERT INTO Tournament_has_Team VALUES (2,4);

INSERT INTO Game VALUES (1,1,1,2,'2015-01-01',null);
INSERT INTO Game VALUES (2,1,3,4,'2015-03-12',null);
INSERT INTO Game VALUES (3,2,4,1,'2015-06-25',null);

INSERT INTO Bet VALUES (1, 3.50,3.50,3.50,false);
INSERT INTO Bet VALUES (3, 3.50,3.50,3.50,false);

INSERT INTO Coupon VALUES (1, 3 , 2, 10);


