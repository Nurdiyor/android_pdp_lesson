CREATE TABLE "Student" (
	"id"	INTEGER NOT NULL UNIQUE,
	"name"	TEXT NOT NULL,
	"surname"	TEXT NOT NULL,
	"age"	INTEGER,
	"number"	TEXT UNIQUE,
	"group"	TEXT NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
);