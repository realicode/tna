#如果复制到mysql中执行时 加上
#DELIMITER ;;

delete from `sys_user` where id>=1 and id<=1000;;
/*默认admin/123456*/
insert into `sys_user`
(`id`, `username`, `email`, `mobile_phone_number`, `password`, `salt`, `create_date`, `status`, `admin`, `deleted`)
  values
  (1, 'admin', 'admin@realaicy.com', '13920888888', 'ec21fa1738f39d5312c6df46002d403d', 'yDd1956wn1', sysdate(), 'normal', 1, 0);;

insert into `sys_user`
(`id`, `username`, `email`, `mobile_phone_number`, `password`, `salt`, `create_date`, `status`, `admin`, `deleted`)
  values
  (2, 'jgw_admin', 'jgw_admin@abssoft.com.cn', '13920111111', '5f915c55c6d43da136a42e3ebabbecfc', 'hSSixwNQwt', sysdate(), 'normal', 1, 0);;

insert into `sys_user`
(`id`, `username`, `email`, `mobile_phone_number`, `password`, `salt`, `create_date`, `status`, `admin`, `deleted`)
  values
  (3, 'qxj_admin', 'qxj_admin@abssoft.com.cn', '13920333333', 'a10b3c7af051a81fe2506318f982ce28', 'MANHOoCpnb', sysdate(), 'normal', 1, 0);;

insert into `sys_user`
(`id`, `username`, `email`, `mobile_phone_number`, `password`, `salt`, `create_date`, `status`, `admin`, `deleted`)
  values
  (4, 'company_a_admin', 'company_a_admin@abssoft.com.cn', '13412345674', '594813c5eb02b210dacc1a36c2482fc1', 'iY71e4dtoa', sysdate(), 'normal', 1, 0);;



delete from `sys_organization` where id>=1 and id<=1000;;
insert into `sys_organization`(`id`, `parent_id`, `parent_ids`, weight, `name`, `is_show`) values (1, 0, '0/', 1, '组织机构', true);;
delete from `sys_job` where id>=1 and id<=1;;
insert into `sys_job`(`id`, `parent_id`, `parent_ids`, weight, `name`, `is_show`) values (1, 0, '0/', 1, '职务', true);;


delete from `sys_resource` where id>=1 and id<=1000;;
insert into `sys_resource`(`id`, `parent_id`, `parent_ids`, weight, `name`, `identity`, `url`, `is_show`)
  values (1, 0, '0/', 1, '资源鼻祖', '', '', true);;


insert into `sys_resource`(`id`, `parent_id`, `parent_ids`, weight, `name`, `identity`, `url`, `is_show`)
  values (2, 1, '0/1/', 2, '系统管理', 'sys:manage', '', true);;
insert into `sys_resource`(`id`, `parent_id`, `parent_ids`, weight, `name`, `identity`, `url`, `is_show`)
  values (3, 2, '0/1/2/', 1, '组织机构管理', '', '', true);;
insert into `sys_resource`(`id`, `parent_id`, `parent_ids`, weight, `name`, `identity`, `url`, `is_show`)
  values (4, 2, '0/1/2/', 2, '角色管理', 'user', '/admin/sys/user/main', true);;

  insert into `sys_resource`(`id`, `parent_id`, `parent_ids`, weight, `name`, `identity`, `url`, `is_show`)
  values (5, 1, '0/1/', 2, '系统状态', 'sys:audit', '', true);;
insert into `sys_resource`(`id`, `parent_id`, `parent_ids`, weight, `name`, `identity`, `url`, `is_show`)
  values (6, 5, '0/1/5/', 1, '应用中间件', '', '', true);;
  insert into `sys_resource`(`id`, `parent_id`, `parent_ids`, weight, `name`, `identity`, `url`, `is_show`)
  values (7, 6, '0/1/5/6', 1, 'SpringBoot', 'sys:audit:m:sp', '/xx/xxx', true);;
insert into `sys_resource`(`id`, `parent_id`, `parent_ids`, weight, `name`, `identity`, `url`, `is_show`)
  values (8, 5, '0/1/5/', 1, '数据库相关', 'user', '/admin/sys/user/main', true);;


delete from `sys_permission` where id>=1 and id<=1000;;
insert into `sys_permission` (`id`, `name`, `permission`, `description`, `is_show`) values (1, '所有', '*', '所有数据操作的权限', 1);;
insert into `sys_permission` (`id`, `name`, `permission`, `description`, `is_show`) values (2, '新增', 'create', '新增数据操作的权限', 1);;
insert into `sys_permission` (`id`, `name`, `permission`, `description`, `is_show`) values (3,  '修改', 'update', '修改数据操作的权限', 1);;
insert into `sys_permission` (`id`, `name`, `permission`, `description`, `is_show`) values (4,  '删除', 'delete', '删除数据操作的权限', 1);;
insert into `sys_permission` (`id`, `name`, `permission`, `description`, `is_show`) values (5,  '查看', 'view', '查看数据操作的权限', 1);;
insert into `sys_permission` (`id`, `name`, `permission`, `description`, `is_show`) values (6,  '审核', 'audit', '审核数据操作的权限', 1);;

delete from `sys_role` where id>=1 and id<=1000;;
insert into `sys_role` (`id`, `name`, `role`, `description`, `is_show`) values (1,  '超级管理员', 'admin', '拥有所有权限', 1);;
insert into `sys_role` (`id`, `name`, `role`, `description`, `is_show`) values (2,  '监管委管理员', 'role_jgw_admin', '拥有监管委的所有权限', 1);;
insert into `sys_role` (`id`, `name`, `role`, `description`, `is_show`) values (3,  '区县局管理员', 'role_qxj_admin', '拥有区县局的所有权限', 1);;
insert into `sys_role` (`id`, `name`, `role`, `description`, `is_show`) values (4,  '企业管理员', 'role_company_admin', '拥有企业的所有权限', 1);;

delete from `sys_role_resource_permission` where id>=1 and id<=1000;;
insert into `sys_role_resource_permission` (`id`, `role_id`, `resource_id`, `permission_ids`) values(1, 1, 2, '1');;
insert into `sys_role_resource_permission` (`id`, `role_id`, `resource_id`, `permission_ids`) values(2, 1, 5, '1');;
insert into `sys_role_resource_permission` (`id`, `role_id`, `resource_id`, `permission_ids`) values(3, 2, 2, '1');;


delete from `sys_auth` where id>=1 and id<=1000;;
insert into sys_auth (`id`, `organization_id`, `job_id`, `user_id`, `group_id`, `role_ids`, `type`)
  values(1, 0, 0, 1, 0, '1', 'user');;
insert into sys_auth (`id`, `organization_id`, `job_id`, `user_id`, `group_id`, `role_ids`, `type`)
  values(2, 0, 0, 2, 0, '2', 'user');;