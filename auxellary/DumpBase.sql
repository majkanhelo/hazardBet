USE hazardBase;

CREATE TABLE Roles (
  Id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  Name VARCHAR(45)  NOT NULL    ,
PRIMARY KEY(Id));


CREATE TABLE Teams (
  Id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  Name VARCHAR(45)  NULL    ,
PRIMARY KEY(Id));


CREATE TABLE Tournaments (
  Id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  Name VARCHAR(45)  NULL    ,
PRIMARY KEY(Id));


CREATE TABLE Users (
  Id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  Role_Id INTEGER UNSIGNED  NOT NULL  ,
  Login VARCHAR(45)  NOT NULL  ,
  UserPassword VARCHAR(45)  NOT NULL    ,
PRIMARY KEY(Id)  ,
INDEX Users_FKIndex1(Role_Id),
  FOREIGN KEY(Role_Id)
    REFERENCES Roles(Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);
      

CREATE TABLE Players (
  User_Id INTEGER UNSIGNED  NOT NULL  ,
  Account FLOAT ZEROFILL  NOT NULL    ,
PRIMARY KEY(User_Id)  ,
INDEX Players_FKIndex1(User_Id),
  FOREIGN KEY(User_Id)
    REFERENCES Users(Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);
      

CREATE TABLE Tournaments_has_Teams (
  Tournament_Id INTEGER UNSIGNED  NOT NULL  ,
  Team_Id INTEGER UNSIGNED  NOT NULL    ,
PRIMARY KEY(Tournament_Id, Team_Id)  ,
INDEX Tournaments_has_Teams_FKIndex1(Tournament_Id)  ,
INDEX Tournaments_has_Teams_FKIndex2(Team_Id),
  FOREIGN KEY(Tournament_Id)
    REFERENCES Tournaments(Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Team_Id)
    REFERENCES Teams(Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);


CREATE TABLE Games (
  Id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  Tournament_Id INTEGER UNSIGNED  NOT NULL  ,
  HomeTeam_Id INTEGER UNSIGNED  NOT NULL  ,
  GuestTeam_Id INTEGER UNSIGNED  NOT NULL  ,
  PlayDate DATE  NOT NULL  ,
  Result VARCHAR(45)  NULL    ,
PRIMARY KEY(Id)  ,
INDEX Games_FKIndex2(Tournament_Id),
  FOREIGN KEY(Tournament_Id)
    REFERENCES Tournaments(Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);


CREATE TABLE Bets (
  Game_Id INTEGER UNSIGNED  NOT NULL  ,
  HomeLoad FLOAT  NOT NULL  ,
  GuestLoad FLOAT  NOT NULL  ,
  DrawLoad FLOAT  NOT NULL  ,
  Resolved BOOL  NOT NULL    ,
PRIMARY KEY(Game_Id)  ,
INDEX Bet_FKIndex1(Game_Id),
  FOREIGN KEY(Game_Id)
    REFERENCES Games(Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

CREATE TABLE Coupons (
  Id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  Bet_Game_Id INTEGER UNSIGNED  NOT NULL  ,
  Player_User_Id INTEGER UNSIGNED  NOT NULL  ,
  BetCash FLOAT  NOT NULL    ,
PRIMARY KEY(Id)  ,
INDEX Coupon_FKIndex1(Player_User_Id)  ,
INDEX Coupon_FKIndex2(Bet_Game_Id),
  FOREIGN KEY(Player_User_Id)
    REFERENCES Players(User_Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Bet_Game_Id)
    REFERENCES Bets(Game_Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);      

      
ALTER TABLE Games ADD FOREIGN KEY Games_HomeTeam(HomeTeam_Id) REFERENCES Teams(Id)
    , ADD FOREIGN KEY Games_GuestTeam(GuestTeam_Id) REFERENCES Teams(Id);

INSERT INTO Roles VALUES (1,'Admin');
INSERT INTO Roles VALUES (2,'Player');

INSERT INTO Teams VALUES (1,'AS Roma');
INSERT INTO Teams VALUES (2,'AC Milan');
INSERT INTO Teams VALUES (3,'Torino');
INSERT INTO Teams VALUES (4,'Juventus Turyn');

INSERT INTO Tournaments VALUES (1,'Serie A');
INSERT INTO Tournaments VALUES (2,'Puchar Wloch');

INSERT INTO Users VALUES (1,1,'AdminMic','obymas');
INSERT INTO Users VALUES (2,2,'PlayerMic','obymas');

INSERT INTO Players VALUES (2,200);

INSERT INTO Tournaments_has_Teams VALUES (1,1);
INSERT INTO Tournaments_has_Teams VALUES (1,2);
INSERT INTO Tournaments_has_Teams VALUES (1,3);
INSERT INTO Tournaments_has_Teams VALUES (1,4);

INSERT INTO Tournaments_has_Teams VALUES (2,1);
INSERT INTO Tournaments_has_Teams VALUES (2,4);

INSERT INTO Games VALUES (1,1,1,2,'2015-01-01',null);
INSERT INTO Games VALUES (2,1,3,4,'2015-03-12',null);
INSERT INTO Games VALUES (3,2,4,1,'2015-06-25',null);

INSERT INTO Bets VALUES (1, 3.50,3.50,3.50,false);
INSERT INTO Bets VALUES (3, 3.50,3.50,3.50,false);

INSERT INTO Coupons VALUES (1, 3 , 2, 10);