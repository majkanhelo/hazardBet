USE hazardBase;

CREATE TABLE Roles (
  rol_id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  rol_name VARCHAR(45)  NOT NULL    ,
PRIMARY KEY(rol_id));


CREATE TABLE Teams (
  Id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  Name VARCHAR(45)  NULL    ,
PRIMARY KEY(Id));


CREATE TABLE Tournaments (
  Id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  Name VARCHAR(45)  NULL    ,
PRIMARY KEY(Id));


CREATE TABLE Users (
  usr_id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  usr_rol_id INTEGER UNSIGNED  NOT NULL  ,
  usr_login VARCHAR(45)  NOT NULL  ,
  usr_password VARCHAR(45)  NOT NULL    ,
  usr_status VARCHAR(45)  NOT NULL    ,
PRIMARY KEY(usr_id)  ,
INDEX Users_FKIndex1(usr_rol_id),
  FOREIGN KEY(usr_rol_id)
    REFERENCES Roles(rol_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);
      

CREATE TABLE Players (
  User_Id INTEGER UNSIGNED  NOT NULL  ,
  Account DOUBLE ZEROFILL  NOT NULL    ,
PRIMARY KEY(User_Id)  ,
INDEX Players_FKIndex1(User_Id),
  FOREIGN KEY(User_Id)
    REFERENCES Users(usr_id)
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
  Winner INTEGER NULL,
PRIMARY KEY(Id)  ,
INDEX Games_FKIndex2(Tournament_Id),
  FOREIGN KEY(Tournament_Id)
    REFERENCES Tournaments(Id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);


CREATE TABLE Bets (
  Game_Id INTEGER UNSIGNED  NOT NULL  ,
  HomeLoad DOUBLE  NOT NULL  ,
  GuestLoad DOUBLE  NOT NULL  ,
  DrawLoad DOUBLE  NOT NULL  ,
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
  Bet_Choose INTEGER UNSIGNED  NOT NULL ,
  BetCash DOUBLE  NOT NULL    ,
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


INSERT INTO Teams VALUES (1,'Juventus Turyn');
INSERT INTO Teams VALUES (2,'AC Milan');
INSERT INTO Teams VALUES (3,'Torino');
INSERT INTO Teams VALUES (4,'AS Roma');


INSERT INTO Tournaments VALUES (1,'Serie A');
INSERT INTO Tournaments VALUES (2,'Puchar Wloch');

INSERT INTO Users VALUES (1,1,'AdminMic','obymas', 'ACTIVE');
INSERT INTO Users VALUES (2,2,'PlayerMic','obymas', 'ACTIVE');

INSERT INTO Players VALUES (2,200);

INSERT INTO Tournaments_has_Teams VALUES (1,1);
INSERT INTO Tournaments_has_Teams VALUES (1,2);
INSERT INTO Tournaments_has_Teams VALUES (1,3);
INSERT INTO Tournaments_has_Teams VALUES (1,4);

INSERT INTO Tournaments_has_Teams VALUES (2,1);
INSERT INTO Tournaments_has_Teams VALUES (2,4);

INSERT INTO Games VALUES (1,1,1,2,'2015-01-01',"",0);
INSERT INTO Games VALUES (2,1,3,4,'2015-03-12',"",0);
INSERT INTO Games VALUES (3,2,4,1,'2015-06-25',"3:1",1);

INSERT INTO Bets VALUES (1, 3.50,3.50,3.50,false);
INSERT INTO Bets VALUES (3, 3.50,3.50,3.50,true);

INSERT INTO Coupons VALUES (1, 3 , 2, 1, 10);