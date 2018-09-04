/** 待选课程 */

	/** 待选课Id   */ private Integer autoId      ;
	/** 选课计划Id */ private Integer xkpId       ;
	/** 课程Id     */ private Integer couId       ;
	/** 教师Id     */ private Integer thrId       ;
	/** 教学班Id   */ private Integer tccId       ; //确认开课后生成
	/** 教学班名称 */ private String  tccName     ;
	/** 场地Id     */ private Integer romId       ;
	/** 总课时     */ private Short   lesNum      ;
	/** 周课时     */ private Byte    weekLesNum  ;
	/** 周课表     */ private Long    weekSchedule;
	/** 课程学分   */ private Double  resultCredit;
	/** 人数下限   */ private Short   manNumLow   ;
	/** 人数上限   */ private Short   manNumUp    ;
	/** 当前人数   */ private Short   manNumCur   ;
	/** 升学/就业  */ private Byte    upOrWork    ;
	/** 性别限制   */ private Byte    limitSex    ; //1所有(默认)  2男  3女
	/** 可选专业   */ private String  limitMajor  ;
	/** 可选学部   */ private String  limitDep    ;
	/** 可选年级   */ private String  limitGrade  ;
	/** 可选班级   */ private String  limitCla    ;
	/** 禁选班级   */ private String  banCla      ;
	/** 选课分组   */ private Integer groupCd     ;
	/** 同组限选   */ private Byte    groupN      ;
	/** 开课类型   */ private Integer couType     ;
	/** 待选课状态 */ private Byte    state       ; //1未开启(默认)  2开启(可选) 3关闭(不可选) 4完成(不可选，已确认成立教学班)
	/** 课程说明   */ private String  couExplain  ;
	/** 学期Id     */ private Integer termId      ;
	/** 计划编号   */ private String  planNO      ;
	/** 计划名称   */ private String  planName    ;
	/** 课程编号   */ private String  couNO       ;
	/** 课程名称   */ private String  couName     ;
	/** 教师编号   */ private String  thrNO       ;
	/** 教师姓名   */ private String  thrName     ;
	/** 教师性别   */ private String  thrSex      ;
	/** 场地编号   */ private String  romNO       ;
	/** 场地名称   */ private String  romName     ;

	/** 排序字段     */ private String[] orderFd; //排序字段的名称，倒序前面加“@”，可以多个
	/** 待选课Id(组) */ private String   autoIds; //多个用“,”隔开

    /** 当前人数(最大) */ private Integer manNumCurMax;
    /** 当前人数(最小) */ private Integer manNumCurMin;
    /** 可选专业编号   */ private String  majorNO;
    /** 可选学部Id     */ private Integer depId;
    /** 可选年级Id     */ private Integer gradeId;
    /** 可选班级Id     */ private Integer claId;

    /** 人数状态：0所有，1少于下限，2大于下限，3达到上限  */ private int manNumState;
    /** 课程时段：0所有，1周一，2周二 ... 5周五           */ private int couTime;

    //==================================================================================================================
    //查询
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：待选课程信息
     * 使用者：教师
     *
     * URL：selCou!query.action
     *
     * 参数：
     * start         必需   记录开始位置
     * limit         必需   获取记录数量
     * planNO        可选   任务编号
     * couName       可选   课程名称(模糊匹配)
     * couId         可选   课程Id
     * termId        可选   学期Id
     * thrId         可选   教师Id
     * tccId         可选   教学班Id
     * tccName       可选   教学班名称(模糊匹配)
     * manNumCurMax  可选   当前人数小于等于该值
     * manNumCurMin  可选   当前人数大于等于该值
     * upOrWork      可选   升学/就业(0不限制，1所有,2升学,3就业)
     * limitSex      可选   限选性别 1所有、2男、3女
     * majorNO       可选   可选专业编号
     * depId         可选   可选学部Id
     * gradeId       可选   可选年级Id
     * claId         可选   可选班级Id
     * groupCd       可选   分组
     * state         可选   状态   1未开启 2开启 3关闭 4完成
     * manNumState   可选   人数状态：0所有，1少于下限，2大于等于下限，3达到上限
     * couTime       可选   课程时段：0所有，1周一，2周二 ... 5周五
     *
     * 出错返回：{"success":false,"message":"错误信息"}
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_SelCourse]}
     *
     */

    //==================================================================================================================
    // 删除
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：删除待选课程信息 (不能删除状态为：2正常）
     * 使用者：教师
     *
     * URL：selCou!del.action
     *
     * 参数：
     * autoIds   必需   信息Id(可以多个)
     *
     * 出错返回：{"success":false,"message":"错误信息"}
     * 正确返回：{"success":true,"message":"删除成功"}
     *
     */

    //==================================================================================================================
    // 修改状态
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：改变待选课程信息状态
     * 使用者：教师
     *
     * URL：selCou!chState.action
     *
     * 参数：
     * autoIds    必需   信息Id(可以多个)
     * state      必需   状态(2启用,3关闭)，当前状态不能是“4完成”
     *
     * 出错返回：{"success":false,"message":"错误信息"}
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
    // 取消学生选课并关闭
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：取消学生选课并关闭
     * 使用者：教师
     *
     * URL：selCou!cancelClose.action
     *
     * 参数：
     * autoIds    必需   信息Id(可以多个)
     *
     * 出错返回：{"success":false,"message":"错误信息"}
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     * 说明：当前状态只能为“2启用”
     *
     */

    //==================================================================================================================

	//==================================================================================================================
    //------------------------------------------------------------------------------------------------------------------
