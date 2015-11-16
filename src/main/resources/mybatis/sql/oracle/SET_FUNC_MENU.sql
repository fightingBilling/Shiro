prompt PL/SQL Developer import file
prompt Created on 2015年11月16日 by Administrator
set feedback off
set define off
prompt Creating SET_FUNC_MENU...
create table SET_FUNC_MENU
(
  MENU_ID          NUMBER not null,
  PMENU_ID         NUMBER not null,
  MENU_CODE        VARCHAR2(64),
  MENU_NAME        VARCHAR2(128) not null,
  MENU_NAME_BRIEF  VARCHAR2(32),
  IS_LEAF          CHAR(1) not null,
  LV               NUMBER not null,
  URL              VARCHAR2(384),
  DISPLAY_ORDER    NUMBER not null,
  STATUS           CHAR(1) not null,
  LAST_UPDATOR     VARCHAR2(32),
  LAST_UPDATE_TIME TIMESTAMP(6)
);

comment on table SET_FUNC_MENU is '功能菜单表';

comment on column SET_FUNC_MENU.IS_LEAF is '0-非叶子菜单，1-叶子菜单';

comment on column SET_FUNC_MENU.STATUS is '0-无效，1-有效';

alter table SET_FUNC_MENU add constraint PK_SET_FUNC_MENU primary key (MENU_ID);

alter table SET_FUNC_MENU add constraint SET_FUNC_MENU_IX1 unique (URL);

prompt Loading SET_FUNC_MENU...
insert into SET_FUNC_MENU (MENU_ID, PMENU_ID, MENU_CODE, MENU_NAME, MENU_NAME_BRIEF, IS_LEAF, LV, URL, DISPLAY_ORDER, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10050, -1, '10050', '后台管理', null, '0', 1, null, 400000, '1', null, null);
insert into SET_FUNC_MENU (MENU_ID, PMENU_ID, MENU_CODE, MENU_NAME, MENU_NAME_BRIEF, IS_LEAF, LV, URL, DISPLAY_ORDER, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10051, 10050, '10050-10051', '用户维护', null, '1', 2, '/mt/user/user_read.html?opt=s7000', 400100, '1', null, null);
insert into SET_FUNC_MENU (MENU_ID, PMENU_ID, MENU_CODE, MENU_NAME, MENU_NAME_BRIEF, IS_LEAF, LV, URL, DISPLAY_ORDER, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10052, 10050, '10050-10052', '角色组维护', null, '1', 2, '/mt/rgroup/rgroup_read.html?opt=s5000', 400200, '1', null, null);
insert into SET_FUNC_MENU (MENU_ID, PMENU_ID, MENU_CODE, MENU_NAME, MENU_NAME_BRIEF, IS_LEAF, LV, URL, DISPLAY_ORDER, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10053, 10050, '10050-10053', '角色维护', null, '0', 2, null, 400300, '1', null, null);
insert into SET_FUNC_MENU (MENU_ID, PMENU_ID, MENU_CODE, MENU_NAME, MENU_NAME_BRIEF, IS_LEAF, LV, URL, DISPLAY_ORDER, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10054, 10050, '10050-10054', '资源维护', null, '1', 2, '/mt/resource/resource_read.html?opt=s2000', 400400, '1', null, null);
insert into SET_FUNC_MENU (MENU_ID, PMENU_ID, MENU_CODE, MENU_NAME, MENU_NAME_BRIEF, IS_LEAF, LV, URL, DISPLAY_ORDER, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10055, 10050, '10050-10055', '菜单维护', null, '1', 2, '/mt/menu/menu_read.html?opt=s3000', 400500, '1', null, null);
insert into SET_FUNC_MENU (MENU_ID, PMENU_ID, MENU_CODE, MENU_NAME, MENU_NAME_BRIEF, IS_LEAF, LV, URL, DISPLAY_ORDER, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10056, 10053, '10050-10053-10056', '功能角色维护', null, '1', 3, '/mt/role/role_menu_read.html?opt=s4000', 400320, '1', null, null);
insert into SET_FUNC_MENU (MENU_ID, PMENU_ID, MENU_CODE, MENU_NAME, MENU_NAME_BRIEF, IS_LEAF, LV, URL, DISPLAY_ORDER, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10057, 10053, '10050-10053-10057', '资源角色维护', null, '1', 3, '/mt/role/role_resource_read.html?opt=s6000', 400310, '1', null, null);
commit;
prompt 8 records loaded
set feedback on
set define on
prompt Done.
