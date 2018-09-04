/** 教学班学生 */

	/** 教学班Id     */ private Integer tccId    ;
	/** 学生Id       */ private Integer stuId    ;
	/** 入班日期     */ private Date    joinDate ;
	/** 离班日期     */ private Date    leaveDate;
	/** 备注         */ private String  remark   ;
	/** 学生状态     */ private Byte    stuState ; //2正常(默认) 3离开
	/** 教学班类型   */ private Byte    tccType  ; //代码类型52 2教学班(默认)、8选课班、9任课班
	/** 教学班编号   */ private String  tccNO    ;
	/** 教学班名称   */ private String  tccName  ;
	/** 教学班年级   */ private Integer tccGrade ; //系统代码35
	/** 教学班专业   */ private Integer tccMajor ; //系统代码3
	/** 教学班校区Id */ private Integer tccCamId ;
	/** 教学班学部Id */ private Integer tccDepId ;
	/** 教学班教室Id */ private Integer tccRomId ;
	/** 教学班教师Id */ private Integer tccThrId ;
	/** 教学班状态   */ private Byte    tccState ; //2正常(默认)、3关闭、4历史
	/** 名单维护     */ private Byte    tccSetStu; //代码类型53、2任教老师、3高级用户(默认)、4关闭维护
	/** 学生学号     */ private String  stuNO    ;
	/** 学生姓名     */ private String  stuName  ;
	/** 性别         */ private String  stuSex   ;
	/** 校区名称     */ private String  camName  ;
	/** 学部名称     */ private String  depName  ;

	/** 排序字段     */ private String[] orderFd; //排序字段的名称，倒序前面加“@”，可以多个
	/** 教学班Id(组) */ private String   tccIds ; //多个用“,”隔开
	/** 任课Id(组)   */ private String   stuIds ; //多个用“,”隔开

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询
	 * 使用者：
	 *
	 * URL：public/tccStu!query.action
	 *
	 * 参数
	 * start      可选   记录开始位置
	 * limit      可选   获取记录数量
	 * tccId      可选   教学班Id
	 * stuId      可选   学生Id
	 * remark     可选   备注
	 * stuState   可选   学生状态 2正常(默认) 3离开
	 * orderFd    可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[TccStu]}
	 *
	 */

	//==================================================================================================================
	// 查询2 -- 引入：班级、学生
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询2 -- 引入：班级、学生
	 * 使用者：
	 *
	 * URL：public/tccStu!query2.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * tccId        可选   教学班Id
	 * stuId        可选   学生Id
	 * remark       可选   备注
	 * stuState     可选   学生状态 2正常(默认) 3离开
	 * tccType      可选   教学班类型 代码类型52 2教学班(默认)、8选课班、9任课班
	 * tccNO        可选   教学班编号
	 * tccName      可选   教学班名称
	 * tccGrade     可选   教学班年级 系统代码35
	 * tccMajor     可选   教学班专业 系统代码3
	 * tccCamId     可选   教学班校区Id
	 * tccDepId     可选   教学班学部Id
	 * tccRomId     可选   教学班教室Id
	 * tccThrId     可选   教学班教师Id
	 * tccState     可选   教学班状态 2正常(默认)、3关闭、4历史
	 * tccSetStu    可选   名单维护 代码类型53、2任教老师、3高级用户(默认)、4关闭维护
	 * stuNO        可选   学生学号
	 * stuName      可选   学生姓名
	 * stuSex       可选   性别
	 * camName      可选   校区名称
	 * depName      可选   学部名称
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_TccStu]}
	 *
	 */

	//==================================================================================================================
	// 新增
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：新增
	 * 使用者：
	 *
	 * URL：public/tccStu!newRec.action
	 *
	 * 参数
	 * tccId      必需   教学班Id
	 * stuId      必需   学生Id
	 * joinDate   可选   入班日期
	 * leaveDate  可选   离班日期
	 * remark     可选   备注
	 * stuState   可选   学生状态 2正常(默认) 3离开
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"data":{TccStu}}
	 *
	 */

	//==================================================================================================================
	// 修改
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：修改
	 * 使用者：
	 *
	 * URL：public/tccStu!edit.action
	 *
	 * 参数
	 * tccId      必需   教学班Id
	 * stuId      必需   学生Id
	 * joinDate   可选   入班日期
	 * leaveDate  可选   离班日期
	 * remark     可选   备注
	 * stuState   可选   学生状态 2正常(默认) 3离开
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 删除
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：删除
	 * 使用者：
	 *
	 * URL：public/tccStu!del.action
	 *
	 * 参数
	 * tccId    必需   教学班Id
	 * stuIds   必需   学生Id   多个用“,”隔开
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

	//==================================================================================================================
