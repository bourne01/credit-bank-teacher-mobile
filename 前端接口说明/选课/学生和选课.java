/** 学生和选课 */

	//说明：提供待选课与学生的关联信息，帮助用户获知一个学生可否选择某课程，即找为什么不可选的原因

	/** 待选课Id     */ private Integer   autoId      ;
	/** 选课计划Id   */ private Integer   xkpId       ;
	/** 课程Id       */ private Integer   couId       ;
	/** 教师Id       */ private Integer   thrId       ;
	/** 教学班Id     */ private Integer   tccId       ; //确认开课后生成
	/** 教学班名称   */ private String    tccName     ;
	/** 场地Id       */ private Integer   romId       ;
	/** 总课时       */ private Short     lesNum      ;
	/** 周课时       */ private Byte      weekLesNum  ;
	/** 周课表       */ private Long      weekSchedule;
	/** 课程学分     */ private Double    resultCredit;
	/** 人数下限     */ private Short     manNumLow   ;
	/** 人数上限     */ private Short     manNumUp    ;
	/** 当前人数     */ private Short     manNumCur   ;
	/** 升学/就业    */ private Byte      upOrWork    ; //1所有(默认)  2升学  3就业
	/** 性别限制     */ private Byte      limitSex    ; //1所有(默认)  2男  3女
	/** 可选专业     */ private String    limitMajor  ;
	/** 可选学部     */ private String    limitDep    ;
	/** 可选年级     */ private String    limitGrade  ;
	/** 可选班级     */ private String    limitCla    ;
	/** 禁选班级     */ private String    banCla      ;
	/** 选课分组     */ private Integer   groupCd     ;
	/** 同组限选     */ private Byte      groupN      ;
	/** 开课类型     */ private Integer   couType     ;
	/** 待选课状态   */ private Byte      selCouState ; //1未开启(默认)  2开启(可选) 3关闭(不可选) 4完成(不可选，已确认成立教学班)
	/** 课程说明     */ private String    couExplain  ;
	/** 学生Id       */ private Integer   stuId       ;
	/** 任务开启时间 */ private Timestamp startTime   ;
	/** 任务关闭时间 */ private Timestamp endTime     ;
	/** 任务状态     */ private Byte      stuTaskState; //1未开启(默认) 2开启 3关闭 4完成
	/** 课程编号     */ private String    couNO       ;
	/** 课程名称     */ private String    couName     ;
	/** 学生学号     */ private String    stuNO       ;
	/** 学生姓名     */ private String    stuName     ;
	/** 性别         */ private String    stuSex      ;
	/** 学部编号     */ private Integer   stuDepId    ;
	/** 年级编号     */ private Integer   stuGrade    ;
	/** 专业编号     */ private Integer   stuMajor    ;
	/** 班级编号     */ private Integer   stuClaId    ;
	/** 班级类型     */ private Byte      stuClaType  ; //代码类型(52) 1行政班、3升学班、4就业班
	/** 班级名称     */ private String    stuClaName  ;

	/** 排序字段     */ private String[] orderFd; //排序字段的名称，倒序前面加“@”，可以多个

	/** 当前状态：0=不符、1=可选         */ public byte stCur    = 1; //考虑了：选课时间、选课任务状态、人数上限 -- 随时可变成可选
	/** 综合条件：0=不符、1=可选         */ public byte stBase   = 1; //不考虑：选课时间、选课任务状态、人数上限 -- 不符合基本的选课条件
	/** 时间状态：0=未到、1=正常、2=已过 */ public byte stTime   = 1;
	/** 性别状态：0=不符、1=正常         */ public byte stSex    = 1;
	/** 班级类型：0=不符、1=正常         */ public byte stClaTp  = 1; //升学班、就业班的限制
	/** 年级限制：0=不符、1=正常         */ public byte stGrade  = 1;
	/** 学部限制：0=不符、1=正常         */ public byte stDep    = 1;
	/** 专业限制：0=不符、1=正常         */ public byte stMajor  = 1;

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询
	 * 使用者：
	 *
	 * URL：stuAndSelCou!query.action
	 *
	 * 参数
	 * start         可选   记录开始位置
	 * limit         可选   获取记录数量
	 * autoId        可选   待选课Id
	 * xkpId         可选   选课计划Id
	 * couId         可选   课程Id
	 * thrId         可选   教师Id
	 * tccId         可选   教学班Id 确认开课后生成
	 * tccName       可选   教学班名称
	 * romId         可选   场地Id
	 * upOrWork      可选   升学/就业 1所有(默认)  2升学  3就业
	 * limitSex      可选   性别限制 1所有(默认)  2男  3女
	 * limitMajor    可选   可选专业
	 * limitDep      可选   可选学部
	 * limitGrade    可选   可选年级
	 * limitCla      可选   可选班级
	 * banCla        可选   禁选班级
	 * groupCd       可选   选课分组
	 * groupN        可选   同组限选
	 * couType       可选   开课类型
	 * selCouState   可选   待选课状态 1未开启(默认)  2开启(可选) 3关闭(不可选) 4完成(不可选，已确认成立教学班)
	 * couExplain    可选   课程说明
	 * stuId         可选   学生Id
	 * stuTaskState  可选   任务状态 1未开启(默认) 2开启 3关闭 4完成
	 * couNO         可选   课程编号
	 * couName       可选   课程名称
	 * stuNO         可选   学生学号
	 * stuName       可选   学生姓名
	 * stuSex        可选   性别
	 * stuDepId      可选   学部编号
	 * stuGrade      可选   年级编号
	 * stuMajor      可选   专业编号
	 * stuClaId      可选   班级编号
	 * stuClaType    可选   班级类型 代码类型(52) 1行政班、3升学班、4就业班
	 * stuClaName    可选   班级名称
	 * orderFd       可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[R_StuAndSelCou]}
	 *
	 */

	//==================================================================================================================
