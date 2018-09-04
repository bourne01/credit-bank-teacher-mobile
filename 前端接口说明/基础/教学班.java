/** 教学班 */

	/** 教学班Id       */ private Integer tccId       ;
	/** 教学班类型     */ private Byte    tccType     ; //代码类型52 2教学班(默认)、8选课班、9任课班
	/** 教学班编号     */ private String  tccNO       ;
	/** 教学班名称     */ private String  tccName     ;
	/** 教学班年级     */ private Integer tccGrade    ; //系统代码35
	/** 教学班专业     */ private Integer tccMajor    ; //系统代码3
	/** 教学班校区Id   */ private Integer tccCamId    ;
	/** 教学班学部Id   */ private Integer tccDepId    ;
	/** 教学班教室Id   */ private Integer tccRomId    ;
	/** 教学班教师Id   */ private Integer tccThrId    ;
	/** 教学班男生数   */ private Integer tccBoyNum   ;
	/** 教学班女生数   */ private Integer tccGirlNum  ;
	/** 教学班开班日期 */ private Date    tccStartDate;
	/** 教学班结束日期 */ private Date    tccEndDate  ;
	/** 教学班状态     */ private Byte    tccState    ; //2正常(默认)、3关闭、4历史
	/** 名单维护       */ private Byte    tccSetStu   ; //代码类型53、2任教老师、3高级用户(默认)、4关闭维护
	/** 教学班备注     */ private String  tccRemark   ;
	/** 校区名称       */ private String  camName     ;
	/** 学部名称       */ private String  depName     ;
	/** 场地名称       */ private String  romName     ;
	/** 教师姓名       */ private String  thrName     ;
	/** 教师性别       */ private String  thrSex      ;

	/** 排序字段     */ private String[] orderFd; //排序字段的名称，倒序前面加“@”，可以多个
	/** 教学班Id(组) */ private String   tccIds ; //多个用“,”隔开

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询
	 * 使用者：
	 *
	 * URL：public/tcc!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * tccId        可选   教学班Id
	 * tccType      可选   教学班类型 代码类型52 2教学班(默认)、8选课班、9任课班
	 * tccNO        可选   教学班编号
	 * tccName      可选   教学班名称
	 * tccGrade     可选   教学班年级 系统代码35
	 * tccMajor     可选   教学班专业 系统代码3
	 * tccCamId     可选   教学班校区Id
	 * tccDepId     可选   教学班学部Id
	 * tccRomId     可选   教学班教室Id
	 * tccThrId     可选   教学班教师Id
	 * tccBoyNum    可选   教学班男生数
	 * tccGirlNum   可选   教学班女生数
	 * tccState     可选   教学班状态 2正常(默认)、3关闭、4历史
	 * tccSetStu    可选   名单维护 代码类型53、2任教老师、3高级用户(默认)、4关闭维护
	 * tccRemark    可选   教学班备注
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[TeachCla]}
	 *
	 */

	//==================================================================================================================
	// 查询2 -- 引入：相关成员的名称
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询2 -- 引入：相关成员的名称
	 * 使用者：
	 *
	 * URL：public/tcc!query2.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * tccId        可选   教学班Id
	 * tccType      可选   教学班类型 代码类型52 2教学班(默认)、8选课班、9任课班
	 * tccNO        可选   教学班编号
	 * tccName      可选   教学班名称
	 * tccGrade     可选   教学班年级 系统代码35
	 * tccMajor     可选   教学班专业 系统代码3
	 * tccCamId     可选   教学班校区Id
	 * tccDepId     可选   教学班学部Id
	 * tccRomId     可选   教学班教室Id
	 * tccThrId     可选   教学班教师Id
	 * tccBoyNum    可选   教学班男生数
	 * tccGirlNum   可选   教学班女生数
	 * tccState     可选   教学班状态 2正常(默认)、3关闭、4历史
	 * tccSetStu    可选   名单维护 代码类型53、2任教老师、3高级用户(默认)、4关闭维护
	 * tccRemark    可选   教学班备注
	 * camName      可选   校区名称
	 * depName      可选   学部名称
	 * romName      可选   场地名称
	 * thrName      可选   教师姓名
	 * thrSex       可选   教师性别
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_TeachCla]}
	 *
	 */

	//==================================================================================================================
	// 新增
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：新增
	 * 使用者：
	 *
	 * URL：public/tcc!newRec.action
	 *
	 * 参数
	 * tccType       可选   教学班类型 代码类型52 2教学班(默认)、8选课班、9任课班
	 * tccNO         可选   教学班编号
	 * tccName       必需   教学班名称
	 * tccGrade      可选   教学班年级 系统代码35
	 * tccMajor      可选   教学班专业 系统代码3
	 * tccCamId      可选   教学班校区Id
	 * tccDepId      可选   教学班学部Id
	 * tccRomId      可选   教学班教室Id
	 * tccThrId      可选   教学班教师Id
	 * tccBoyNum     可选   教学班男生数
	 * tccGirlNum    可选   教学班女生数
	 * tccStartDate  可选   教学班开班日期
	 * tccEndDate    可选   教学班结束日期
	 * tccState      可选   教学班状态 2正常(默认)、3关闭、4历史
	 * tccSetStu     可选   名单维护 代码类型53、2任教老师、3高级用户(默认)、4关闭维护
	 * tccRemark     可选   教学班备注
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"data":{TeachCla}}
	 *
	 */

	//==================================================================================================================
	// 修改
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：修改
	 * 使用者：
	 *
	 * URL：public/tcc!edit.action
	 *
	 * 参数
	 * tccId         必需   教学班Id
	 * tccType       可选   教学班类型 代码类型52 2教学班(默认)、8选课班、9任课班
	 * tccNO         可选   教学班编号
	 * tccName       可选   教学班名称
	 * tccGrade      可选   教学班年级 系统代码35
	 * tccMajor      可选   教学班专业 系统代码3
	 * tccCamId      可选   教学班校区Id
	 * tccDepId      可选   教学班学部Id
	 * tccRomId      可选   教学班教室Id
	 * tccThrId      可选   教学班教师Id
	 * tccBoyNum     可选   教学班男生数
	 * tccGirlNum    可选   教学班女生数
	 * tccStartDate  可选   教学班开班日期
	 * tccEndDate    可选   教学班结束日期
	 * tccState      可选   教学班状态 2正常(默认)、3关闭、4历史
	 * tccSetStu     可选   名单维护 代码类型53、2任教老师、3高级用户(默认)、4关闭维护
	 * tccRemark     可选   教学班备注
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

    //==================================================================================================================
    // 修改记录状态
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：修改记录状态
     * 使用者：
     *
     * URL：public/tcc!chState.action
     *
     * 参数：
	 * tccIds    必需   教学班Id 多个用“,”隔开
     * tccState  必需   新状态
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息！"}
     *
     */

	//==================================================================================================================
	// 删除
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：删除
	 * 使用者：
	 *
	 * URL：public/tcc!del.action
	 *
	 * 参数
	 * tccIds   必需   教学班Id 多个用“,”隔开
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

	//==================================================================================================================
