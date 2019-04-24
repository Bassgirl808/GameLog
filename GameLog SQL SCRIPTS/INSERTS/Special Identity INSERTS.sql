SET IDENTITY_INSERT [dbo].CUSTOMER ON;
INSERT INTO CUSTOMER(ID, USERNAME, RHOURS, RMINS, RSECS) VALUES(0, 'system', 0, 0, 0);
SET IDENTITY_INSERT [dbo].CUSTOMER OFF;

SET IDENTITY_INSERT [dbo].CONSOLE ON;
INSERT INTO CONSOLE(ID, CUSTOMER_ID, CONSOLENAME) VALUES(0, 0, 'system');
SET IDENTITY_INSERT [dbo].CONSOLE OFF;

SET IDENTITY_INSERT [dbo].GAME ON;
INSERT INTO GAME(ID, CONSOLE_ID, GAMENAME) VALUES(0, 0, 'N/A');
SET IDENTITY_INSERT [dbo].GAME OFF;

SET IDENTITY_INSERT [dbo].ACCESSORY ON;
INSERT INTO ACCESSORY(ID, CONSOLE_ID, CUSTOMER_ID, ACCESSNAME) VALUES(0, 0, 0, 'N/A');
SET IDENTITY_INSERT [dbo].ACCESSORY OFF;


