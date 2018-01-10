/* Map invalid user ids in WCM */

update DDMStructure set userid = 10159 where userid = 10729;
update DDMTemplate set userid = 10159 where userid = 10729;
update DDMStructureVersion set userid = 10159 where userid = 10729;