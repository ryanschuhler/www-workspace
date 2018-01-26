/* Map invalid user ids in WCM */

update DDMStructure set userid = 10159 where userid in (10729, 154427);
update DDMTemplate set userid = 10159 where userid in (10729, 154427, 2011773);

update DDMTemplate template 
inner join DDMStructure structure
on  template.classpk = structure.structureid
set template.groupId = structure.groupId
where template.groupId <> structure.groupId;

delete from DDMStructure where groupid = 231465858;
delete from DDMTemplate where groupid = 231465858;


update LayoutSet set themeId = 'osb-community-theme' where themeId = 'osbcommunity_WAR_osbcommunitytheme';
update Layout set themeId = 'osb-community-theme' where themeId = 'osbcommunity_WAR_osbcommunitytheme';
update LayoutSetBranch set themeId = 'osb-community-theme' where themeId = 'osbcommunity_WAR_osbcommunitytheme';
update LayoutRevision set themeId = 'osb-community-theme' where themeId = 'osbcommunity_WAR_osbcommunitytheme';
