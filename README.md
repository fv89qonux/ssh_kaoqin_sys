## 本项目实现的最终作用是基于SSH公司员工考勤管理系统
## 分为1个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 公告管理
 - 分类查看员工
 - 员工考勤管理
 - 员工薪酬管理
 - 管理员登陆
 - 职位管理
 - 账号管理
 - 部门管理
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_kaoqin_sys

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [te_account](#te_account) |  |
| [te_account_role](#te_account_role) |  |
| [te_address](#te_address) |  |
| [te_choose_education](#te_choose_education) |  |
| [te_choose_marriage](#te_choose_marriage) |  |
| [te_choose_national](#te_choose_national) |  |
| [te_choose_politics](#te_choose_politics) |  |
| [te_city](#te_city) |  |
| [te_county](#te_county) |  |
| [te_department](#te_department) |  |
| [te_employees_attendance](#te_employees_attendance) |  |
| [te_employees_basic](#te_employees_basic) |  |
| [te_employees_company](#te_employees_company) |  |
| [te_employees_detail](#te_employees_detail) |  |
| [te_employees_log](#te_employees_log) |  |
| [te_employees_reward](#te_employees_reward) |  |
| [te_employees_salary](#te_employees_salary) |  |
| [te_employees_training_log](#te_employees_training_log) |  |
| [te_module](#te_module) |  |
| [te_note](#te_note) |  |
| [te_position](#te_position) |  |
| [te_province](#te_province) |  |
| [te_role](#te_role) |  |
| [te_role_module](#te_role_module) |  |
| [te_township](#te_township) |  |
| [te_training](#te_training) |  |
| [te_training_note](#te_training_note) |  |
| [te_village](#te_village) |  |

**表名：** <a id="te_account">te_account</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | acctId |   bigint   | 20 |   0    |    N     |  Y   |       | 账户ID  |
|  2   | acctName |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 账户名  |
|  3   | acctNickname |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 名称  |
|  4   | acctPassword |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 密码  |
|  5   | acctState |   int   | 10 |   0    |    Y     |  N   |   0    | 帐号状态  |
|  6   | acctSuper |   tinyint   | 4 |   0    |    Y     |  N   |   0    | 是否为超级管理员  |
|  7   | acctDeleteState |   tinyint   | 4 |   0    |    Y     |  N   |   0    | 删除状态  |
|  8   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  9   | creator |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 创建人  |
|  10   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_account_role">te_account_role</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | aoId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | acctName |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 账户名  |
|  3   | roleLabel |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 角色标识  |
|  4   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_address">te_address</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | adsId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | adsType |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  3   | adsProvince |   bigint   | 20 |   0    |    Y     |  N   |   0    | 省份ID  |
|  4   | adsCity |   bigint   | 20 |   0    |    Y     |  N   |   0    | 市级ID  |
|  5   | adsCounty |   bigint   | 20 |   0    |    Y     |  N   |   0    | 县级ID  |
|  6   | adsTownship |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  7   | adsVillage |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  8   | adsDetailed |   varchar   | 512 |   0    |    Y     |  N   |   NULL    |   |
|  9   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_choose_education">te_choose_education</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | eduId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | eduName |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 学历名称  |
|  3   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_choose_marriage">te_choose_marriage</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | marId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | marName |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 婚姻状况名称  |
|  3   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_choose_national">te_choose_national</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | natId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | natName |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 名称  |
|  3   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_choose_politics">te_choose_politics</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | polId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | polName |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 名称  |
|  3   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_city">te_city</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | cityId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | cityName |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  3   | cityCode |   varchar   | 3 |   0    |    N     |  N   |       |   |
|  4   | provinceId |   bigint   | 20 |   0    |    N     |  N   |       |   |

**表名：** <a id="te_county">te_county</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | countyId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | countyName |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  3   | countyCode |   varchar   | 3 |   0    |    N     |  N   |       |   |
|  4   | cityId |   bigint   | 20 |   0    |    N     |  N   |       |   |

**表名：** <a id="te_department">te_department</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | deptId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | deptName |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 部门名称  |
|  3   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  4   | creator |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 创建人  |
|  5   | deptDescription |   varchar   | 1024 |   0    |    Y     |  N   |   NULL    | 部门简介  |
|  6   | deptPrincipal |   bigint   | 20 |   0    |    Y     |  N   |   0    | 负责人ID  |
|  7   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_employees_attendance">te_employees_attendance</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | attenId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | emId |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  3   | atteTime |   varchar   | 12 |   0    |    Y     |  N   |   NULL    |   |
|  4   | morning |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | afternoon |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  7   | creator |   varchar   | 64 |   0    |    Y     |  N   |   NULL    |   |
|  8   | timestamp |   timestamp   | 19 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="te_employees_basic">te_employees_basic</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | emId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | emState |   int   | 10 |   0    |    Y     |  N   |   0    | 员工状态  |
|  3   | emPhoto |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 头像  |
|  4   | emFullName |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 员工姓名  |
|  5   | emSex |   tinyint   | 4 |   0    |    Y     |  N   |   0    | 性别  |
|  6   | emIdentity |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 身份证号码  |
|  7   | emBirthday |   varchar   | 16 |   0    |    Y     |  N   |   NULL    | 出生日期  |
|  8   | emParticipateTime |   varchar   | 12 |   0    |    Y     |  N   |   NULL    | 入职时间  |
|  9   | emPhone |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 联系电话  |
|  10   | emSocialSecurity |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 社保卡号  |
|  11   | emDeparemtn |   bigint   | 20 |   0    |    Y     |  N   |   0    | 部门  |
|  12   | emPosition |   bigint   | 20 |   0    |    Y     |  N   |   0    | 职位  |
|  13   | emEducation |   bigint   | 20 |   0    |    Y     |  N   |   0    | 文化程度  |
|  14   | emMarriage |   bigint   | 20 |   0    |    Y     |  N   |   0    | 婚姻状况  |
|  15   | emPolitics |   bigint   | 20 |   0    |    Y     |  N   |   0    | 政治面貌  |
|  16   | emNational |   bigint   | 20 |   0    |    Y     |  N   |   0    | 民族  |
|  17   | emCurrentAddress |   bigint   | 20 |   0    |    Y     |  N   |   0    | 现居住地址  |
|  18   | emCensusRegister |   bigint   | 20 |   0    |    Y     |  N   |   0    | 户籍地址  |
|  19   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 添加时间  |
|  20   | creator |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 创建者  |
|  21   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_employees_company">te_employees_company</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | comId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | emplNo |   bigint   | 20 |   0    |    Y     |  N   |   NULL    | 员工ID号  |
|  3   | comName |   varchar   | 256 |   0    |    Y     |  N   |   NULL    | 单位名称  |
|  4   | comParticipateTime |   varchar   | 12 |   0    |    Y     |  N   |   NULL    | 入职时间  |
|  5   | comLeaveTime |   varchar   | 12 |   0    |    Y     |  N   |   NULL    | 离职时间  |
|  6   | comPosition |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 岗位  |
|  7   | comReason |   varchar   | 1024 |   0    |    Y     |  N   |   NULL    | 离职原因  |
|  8   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_employees_detail">te_employees_detail</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | emId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | emplNo |   bigint   | 20 |   0    |    Y     |  N   |   NULL    | 员工编号  |
|  3   | emContact |   varchar   | 1024 |   0    |    Y     |  N   |   NULL    | 其他联系方式  |
|  4   | emEmergencyContact |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 紧急联系人  |
|  5   | emEmergencyPhone |   varchar   | 1024 |   0    |    Y     |  N   |   NULL    | 紧急联系方式  |
|  6   | emSchool |   varchar   | 1024 |   0    |    Y     |  N   |   NULL    | 毕业校院  |
|  7   | emProfessional |   varchar   | 1024 |   0    |    Y     |  N   |   NULL    | 就读专业  |
|  8   | emGraduationTime |   varchar   | 12 |   0    |    Y     |  N   |   NULL    | 毕业时间  |
|  9   | emSchooling |   varchar   | 256 |   0    |    Y     |  N   |   NULL    | 学历  |
|  10   | emDegree |   varchar   | 256 |   0    |    Y     |  N   |   NULL    | 学位  |
|  11   | emIsSocialSecurity |   tinyint   | 4 |   0    |    Y     |  N   |   NULL    | 是否缴纳社保  |
|  12   | emNote |   text   | 65535 |   0    |    Y     |  N   |   NULL    | 备注  |
|  13   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_employees_log">te_employees_log</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | emplId |   bigint   | 20 |   0    |    Y     |  N   |   0    | 员工ID号  |
|  3   | type |   int   | 10 |   0    |    Y     |  N   |   0    | 记录类型  |
|  4   | note |   varchar   | 1024 |   0    |    Y     |  N   |   NULL    | 备注  |
|  5   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 操作时间  |
|  6   | creator |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 创建人  |
|  7   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_employees_reward">te_employees_reward</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | emId |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  3   | type |   int   | 10 |   0    |    Y     |  N   |   NULL    | 类型  |
|  4   | title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |
|  5   | amount |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | content |   varchar   | 2048 |   0    |    Y     |  N   |   NULL    | 内容  |
|  7   | creator |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | createTime |   varchar   | 64 |   0    |    Y     |  N   |   NULL    |   |
|  9   | timestamp |   timestamp   | 19 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="te_employees_salary">te_employees_salary</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | emoId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | emId |   bigint   | 20 |   0    |    N     |  N   |       |   |
|  3   | salary |   int   | 10 |   0    |    N     |  N   |       |   |
|  4   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  5   | creator |   varchar   | 64 |   0    |    Y     |  N   |   NULL    |   |
|  6   | timestamp |   timestamp   | 19 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="te_employees_training_log">te_employees_training_log</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | state |   int   | 10 |   0    |    Y     |  N   |   NULL    | 培训记录状态  |
|  3   | emplId |   bigint   | 20 |   0    |    Y     |  N   |   0    | 员工ID  |
|  4   | trainingItemId |   bigint   | 20 |   0    |    Y     |  N   |   0    | 培训项目ID  |
|  5   | applyTime |   varchar   | 12 |   0    |    Y     |  N   |   NULL    | 报名时间  |
|  6   | note |   varchar   | 1024 |   0    |    Y     |  N   |   NULL    | 备注  |
|  7   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 记录创建时间  |
|  8   | creator |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 创建者  |
|  9   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_module">te_module</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | moduleId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | moduleName |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 模块名称  |
|  3   | moduleCode |   varchar   | 12 |   0    |    Y     |  N   |   '0'    | 模块编号  |
|  4   | moduleSuperCode |   varchar   | 12 |   0    |    Y     |  N   |   NULL    |   |
|  5   | modulePage |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | moduleLevel |   int   | 10 |   0    |    Y     |  N   |   0    | 等级  |
|  7   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_note">te_note</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | creator |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |
|  4   | content |   varchar   | 2048 |   0    |    Y     |  N   |   NULL    | 内容  |
|  5   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |

**表名：** <a id="te_position">te_position</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | poId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | poDepartment |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  3   | poName |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 职位名称  |
|  4   | poDescription |   varchar   | 1024 |   0    |    Y     |  N   |   NULL    | 职位简介  |
|  5   | creator |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 操作人  |
|  6   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 添加时间  |
|  7   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_province">te_province</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | provinceId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | provinceName |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  3   | provinceCode |   varchar   | 3 |   0    |    N     |  N   |       |   |
|  4   | language |   varchar   | 12 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="te_role">te_role</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | roleId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | roleName |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 角色名称  |
|  3   | roleDescription |   varchar   | 1024 |   0    |    Y     |  N   |   NULL    |   |
|  4   | roleLabel |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 角色唯一标识  |
|  5   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  6   | creator |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 创建人  |
|  7   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_role_module">te_role_module</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | roleLabel |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 唯一角色标识  |
|  3   | moduleCode |   varchar   | 12 |   0    |    Y     |  N   |   NULL    |   |
|  4   | mosuleSuperCode |   varchar   | 12 |   0    |    Y     |  N   |   NULL    | 上级  |
|  5   | finds |   tinyint   | 4 |   0    |    Y     |  N   |   0    |   |
|  6   | adds |   tinyint   | 4 |   0    |    Y     |  N   |   0    |   |
|  7   | deletes |   tinyint   | 4 |   0    |    Y     |  N   |   0    |   |
|  8   | modifys |   tinyint   | 4 |   0    |    Y     |  N   |   0    |   |
|  9   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_township">te_township</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | townshipId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | townshipName |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  3   | townshipCode |   varchar   | 3 |   0    |    N     |  N   |       |   |
|  4   | countyId |   bigint   | 20 |   0    |    N     |  N   |       |   |

**表名：** <a id="te_training">te_training</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 项目名称  |
|  3   | description |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 项目简介  |
|  4   | number |   int   | 10 |   0    |    Y     |  N   |   0    | 培训人数  |
|  5   | startTime |   varchar   | 16 |   0    |    Y     |  N   |   NULL    | 开始时间  |
|  6   | endTime |   varchar   | 16 |   0    |    Y     |  N   |   NULL    | 结束时间  |
|  7   | isInsertAttend |   tinyint   | 4 |   0    |    Y     |  N   |   0    | 是否允许中途参加  |
|  8   | state |   int   | 10 |   0    |    Y     |  N   |   NULL    | 培训状态  |
|  9   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 添加时间  |
|  10   | creator |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 创建人  |
|  11   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_training_note">te_training_note</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | trainingId |   bigint   | 20 |   0    |    Y     |  N   |   0    | 培训项目ID  |
|  3   | state |   int   | 10 |   0    |    Y     |  N   |   0    | 培训项目状态  |
|  4   | note |   varchar   | 2048 |   0    |    Y     |  N   |   NULL    | 备注信息  |
|  5   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  6   | creator |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 创造者  |
|  7   | timestamp |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |

**表名：** <a id="te_village">te_village</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | villageId |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | villageName |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  3   | villageCode |   varchar   | 3 |   0    |    N     |  N   |       |   |
|  4   | townshipId |   bigint   | 20 |   0    |    N     |  N   |       |   |

