/** 排课细计划 */

	/** 排课计划明细Id     */ private Integer scpDId    ;
	/** 排课计划Id         */ private Integer scpId     ;
	/** 归属部门Id         */ private Integer depId     ; //默认-1表示无归属部门
	/** 归属教研组         */ private Integer rshId     ; //默认-1表示无归属教研组
	/** 教师设置           */ private Byte    thrSet    ;
	/** 课程设置           */ private Byte    couSet    ;
	/** 班级设置           */ private Byte    claSet    ; //1独立(默认) 2合并 3子集 4重组 5重组(自动)
	/** 场地设置           */ private Byte    romSet    ;
	/** 开课周             */ private Integer weekHave  ;
	/** 周课时             */ private Byte    weekLesNum;
	/** 方案课时(总)       */ private Byte    scmLesNumTotal;
	/** 已排课时(总)       */ private Byte    setLesNumTotal;
	/** 开课类型           */ private Integer couType   ; //代码类型11
	/** 学分               */ private Double  credit    ;
	/** 连课数             */ private Byte    dayLesNum ;
	/** 备注               */ private String  remark    ;
	/** 明细计划状态       */ private Byte    scpDState ; //2正常(默认) 3关闭 4完成
	/** 排课学期Id         */ private Integer termId    ;
	/** 排课计划名称       */ private String  scpName   ;
	/** 学部名称           */ private String  depName   ;
	/** 教研组名称         */ private String  rshName   ;
	/** 教师Id(组)         */ private String  thrIds    ;
	/** 课程Id(组)         */ private String  couIds    ;
	/** 教师姓名(组)       */ private String  thrNms    ;
	/** 课程名称(组)       */ private String  couNms    ;
	/** 行政班Id(组)       */ private String  claIds    ;
	/** 行政班名称(组)     */ private String  claNms    ;
	/** 教学班Id(组)       */ private String  tccIds    ;
	/** 教学班名称(组)     */ private String  tccNms    ;
	/** 场地Id(组)         */ private String  romIds    ;
	/** 场地名称(组)       */ private String  romNms    ;
	/** 教师已排课时(组)   */ private String  thrLesNums;
	/** 行政班已排课时(组) */ private String  claLesNums;
	/** 教学班已排课时(组) */ private String  tccLesNums;
	/** 场地已排课时(组)   */ private String  romLesNums;

	/** 教师Id     */ private String  thrId  ;
	/** 课程Id     */ private String  couId  ;
	/** 班级Id     */ private String  claId  ;
	/** 班级Id     */ private String  tccId  ;
	/** 场地Id     */ private String  romId  ;
	/** 教师姓名   */ private String  thrName;
	/** 课程名称   */ private String  couName;
	/** 班级名称   */ private String  claName;
	/** 教学班名称 */ private String  tccName;
	/** 场地名称   */ private String  romName;

	/** 排序字段           */ private String[] orderFd    ; //排序字段的名称，倒序前面加“@”，可以多个
	/** 排课计划明细Id(组) */ private String   scpDIds    ; //多个用“,”隔开
	/** 查询参数           */ private Byte     finish     ;
    /** 位化开课周         */ private String   bitStrWeekH;

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询
	 * 使用者： + 部门负责人(自己负责的部门)
	 *
	 * URL：schedPlanD!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * scpDId       可选   排课计划明细Id
	 * scpId        可选   排课计划Id
	 * depId        可选   归属部门Id 默认-1表示无归属部门
	 * rshId        可选   归属教研组 默认-1表示无归属教研组
	 * thrSet       可选   教师设置
	 * couSet       可选   课程设置
	 * claSet       可选   班级设置 1独立(默认) 2合并 3子集 4重组 5重组(自动)
	 * romSet       可选   场地设置
	 * weekHave     可选   开课周
	 * weekLesNum   可选   周课时
	 * finish       可选   课时是否已排完：0(默认)=无限制、1=未排完、2=已排完
	 * couType      可选   开课类型 代码类型11
	 * credit       可选   学分
	 * dayLesNum    可选   连课数
	 * remark       可选   备注
	 * scpDState    可选   明细计划状态 2正常(默认) 3关闭 4完成
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[SchedPlanD]}
	 *
	 */

	//==================================================================================================================
	// 查询2 -- 引入所有成员 + 名称
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询2 -- 引入所有成员 + 名称
	 * 使用者： + 部门负责人(自己负责的部门)
	 *
	 * URL：schedPlanD!query2.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * scpDId       可选   排课计划明细Id
	 * scpId        可选   排课计划Id
	 * depId        可选   归属部门Id 默认-1表示无归属部门
	 * rshId        可选   归属教研组 默认-1表示无归属教研组
	 * thrSet       可选   教师设置
	 * couSet       可选   课程设置
	 * claSet       可选   班级设置 1独立(默认) 2合并 3子集 4重组 5重组(自动)
	 * romSet       可选   场地设置
	 * weekHave     可选   开课周
	 * weekLesNum   可选   周课时
	 * finish       可选   课时是否已排完：0(默认)=无限制、1=未排完、2=已排完
	 * couType      可选   开课类型 代码类型11
	 * credit       可选   学分
	 * dayLesNum    可选   连课数
	 * remark       可选   备注
	 * scpDState    可选   明细计划状态 2正常(默认) 3关闭 4完成
	 * termId       可选   排课学期Id
	 * scpName      可选   排课计划名称
	 * depName      可选   学部名称
	 * rshName      可选   教研组名称
	 * thrIds       可选   教师Id(组) 多个用“,”隔开
	 * couIds       可选   课程Id(组) 多个用“,”隔开
	 * claIds       可选   班级Id(组) 多个用“,”隔开
	 * tccIds       可选   班级Id(组) 多个用“,”隔开
	 * romIds       可选   场地Id(组) 多个用“,”隔开
	 * thrName      可选   教师姓名
	 * couName      可选   课程名称
	 * claName      可选   班级名称
	 * tccName      可选   教学班名称
	 * romName      可选   场地名称
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_SchedPlanD]}
	 *
	 */

    //==================================================================================================================
    // 导出
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：导出
     * 使用者：
     *
     * URL：schedPlanD/export.action
     *
     * 参数：参考query2
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：文件
     *
     */

	//==================================================================================================================
	// 新增
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：新增
	 * 使用者： + 部门负责人(自己负责的部门)
	 *
	 * URL：schedPlanD!newRec.action
	 *
	 * 参数
	 * scpId        必需   排课计划Id
	 * depId        可选   归属部门Id 默认-1表示无归属部门
	 * rshId        可选   归属教研组 默认-1表示无归属教研组
	 * thrSet       可选   教师设置
	 * couSet       可选   课程设置
	 * claSet       可选   班级设置 1独立(默认) 2合并 3子集 4重组 5重组(自动)
	 * romSet       可选   场地设置
	 * weekLesNum   可选   周课时
	 * couType      可选   开课类型 代码类型11
	 * credit       可选   学分
	 * dayLesNum    可选   连课数
	 * remark       可选   备注
	 * thrIds       可选   教师Id(组) 多个用“,”隔开
	 * couIds       可选   课程Id(组) 多个用“,”隔开
	 * claIds       可选   班级Id(组) 多个用“,”隔开
	 * tccIds       可选   班级Id(组) 多个用“,”隔开
	 * romIds       可选   场地Id(组) 多个用“,”隔开
	 * tccNms       可选   班级名称(组) 多个用“,”隔开；用于当对应的教学班Id为0时，自动创建教学班
     * bitStrWeekH  可选   位化开课周 默认取排课主计划的开课周设置
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功能信息","data":{V_SchedPlanD}}
	 *
	 */

	//==================================================================================================================
	// 修改
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：修改
	 * 使用者： + 部门负责人(自己负责的部门)
	 *
	 * URL：schedPlanD!edit.action
	 *
	 * 参数
	 * scpDId       必需   排课计划明细Id
	 * scpId        可选   排课计划Id
	 * depId        可选   归属部门Id 默认-1表示无归属部门
	 * rshId        可选   归属教研组 默认-1表示无归属教研组
	 * thrSet       可选   教师设置
	 * couSet       可选   课程设置
	 * claSet       可选   班级设置 1独立(默认) 2合并 3子集 4重组 5重组(自动)
	 * romSet       可选   场地设置
	 * weekLesNum   可选   周课时
	 * couType      可选   开课类型 代码类型11
	 * credit       可选   学分
	 * dayLesNum    可选   连课数
	 * remark       可选   备注
	 * thrIds       可选   教师Id(组)       多个用“,”隔开
	 * couIds       可选   课程Id(组)       多个用“,”隔开
	 * claIds       可选   班级Id(组)       多个用“,”隔开
	 * tccIds       可选   班级Id(组)       多个用“,”隔开
	 * romIds       可选   场地Id(组)       多个用“,”隔开
	 * tccNms       可选   班级名称(组)     多个用“,”隔开；用于当对应的教学班Id为0时，自动创建教学班
     * bitStrWeekH  可选   位化开课周 默认取排课主计划的开课周设置
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
	 * URL：schedPlanD!chState.action
	 *
	 * 参数
	 * scpDIds    必需   排课计划明细Id 多个用“,”隔开
	 * scpDState  必需   明细计划状态 2正常(默认) 3关闭 4完成
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
	 * 使用者： + 部门负责人(自己负责的部门)
	 *
	 * URL：schedPlanD!del.action
	 *
	 * 参数
	 * scpDIds   必需   排课计划明细Id 多个用“,”隔开
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 * 注意：部门负责人只能删除“2正常”状态的记录，管理员只能删除“4完成”状态的记录
	 *
	 */

	//==================================================================================================================
