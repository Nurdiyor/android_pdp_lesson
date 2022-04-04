CREATE TABLE "group_teacher_connection" (
	"id"	INTEGER NOT NULL UNIQUE,
	"group_id"	INTEGER NOT NULL,
	"teacher_id"	INTEGER NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT),
	 FOREIGN KEY("group_id") REFERENCES "groups"("id"),
	  FOREIGN KEY("teacher_id") REFERENCES "teachers"("id")
);