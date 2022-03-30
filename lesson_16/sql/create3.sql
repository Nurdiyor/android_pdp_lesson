CREATE TABLE "student" (
	"id"	INTEGER NOT NULL UNIQUE,
	"name"	TEXT NOT NULL,
	"number"	TEXT UNIQUE,
	"group_id"	INTEGER NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY ("group_id") REFERENCES 'group'("id")
);