/* Map invalid user ids in WCM */

update DDMStructure set userid = 10159 where userid in (10729, 154427);
update DDMStructureVersion set userid = 10159 where userid in (10729, 154427); 
update DDMTemplate set userid = 10159 where userid in (10729, 154427, 2011773);
update DDMTemplateVersion set userid = 10159 where userid in (10729, 154427, 2011773);