/** 待选课编辑 */

	// 由于旧版这个就是独出来的，所以这里也从“SelCourseAct”中独立出来

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
	/** 升学/就业  */ private Byte    upOrWork    ; //1所有 2升学 3就业
	/** 性别限制   */ private Byte    limitSex    ; //1所有 2男   3女
	/** 可选专业   */ private String  limitMajor  ;
	/** 可选学部   */ private String  limitDep    ;
	/** 可选年级   */ private String  limitGrade  ;
	/** 可选班级   */ private String  limitCla    ;
	/** 禁选班级   */ private String  banCla      ;
	/** 选课分组   */ private Integer groupCd     ; //代码类型47
	/** 同组限选   */ private Byte    groupN      ;
	/** 开课类型   */ private Integer couType     ; //代码类型11
	/** 待选课状态 */ private Byte    state       ; //1未开启(默认)  2开启(可选) 3关闭(不可选) 4完成(不可选，已确认成立教学班)
	/** 课程说明   */ private String  couExplain  ;

    /** 选课计划编号       */ private String   planNO   ;
    /** 可选专业编号(多个) */ private String[] majNOs   ;
    /** 可选学部Id(多个)   */ private int[]    depIds   ;
    /** 可选年级Id(多个)   */ private int[]    graIds   ;
    /** 可选班级Id(多个)   */ private int[]    claIds   ;
    /** 禁选班级Id(多个)   */ private int[]    banClaIds;
    /** 周课表(按位字符化) */ private String   weekSched;

    //==================================================================================================================
    // 新增
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增待选课程
     * 使用者：教师
     *
     * URL：editSelCou!newSelCou.action
     *
     * 参数：
     * planNO        必需   选课计划编号(如果存在xkpId，将忽略该参数)
     * couId         必需   课程Id
     * thrId         可选   教师Id
     * tccName       可选   教学班名称
     * romId         可选   场地Id
     * lesNum        可选   总课时
     * weekLesNum    可选   周课时
     * resultCredit  可选   课程学分
     * manNumLow     可选   人数下限
     * manNumUp      可选   人数上限
     * manNumCur     可选   当前人数
     * upOrWork      必需   升学/就业 1所有 2升学 3就业
     * limitSex      必需   限选性别  1所有 2男 3女
     * groupCd       必需   选课分组
     * groupN        可选   同组限选
     * couType       必需   开课类型
     * majNOs        必需   可选专业编号(多个) --> limitMajor  注意：不指定代表所有专业可选
     * depIds        必需   可选学部Id(多个)   --> limitDep    注意：不指定代表所有学部可选
     * graIds        必需   可选年级Id(多个)   --> limitGrade  注意：不指定代表所有年级可选
     * claIds        必需   可选班级Id(多个)   --> limitCla    注意：不指定代表所有班级可选
     * banClaIds     必需   禁选班级Id(多个)   --> banCla      注意：不指定代表所有班级可选
     * weekSched     必需   周课表(按位字符化) --> weekSchedule
	 * couExplain    可选   课程说明
     *
     * 出错返回：{"success":false,"message":"错误信息"}
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
    //修改
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：修改待选课程
     * 使用者：教师
     *
     * URL：editSelCou!editSelCou.action
     *
     * 参数：
     * autoId        必需   待选课Id
     * planNO        可选   选课计划编号
     * couId         可选   课程Id
     * thrId         可选   教师Id
     * tccName       可选   教学班名称
     * romId         可选   场地Id
     * lesNum        可选   总课时
     * weekLesNum    可选   周课时
     * resultCredit  可选   课程学分
     * manNumLow     可选   人数下限
     * manNumUp      可选   人数上限
     * manNumCur     可选   当前人数
     * upOrWork      可选   升学/就业 1所有 2升学 3就业
     * limitSex      可选   限选性别  1所有 2男 3女
     * groupCd       可选   选课分组
     * groupN        可选   同组限选
     * couType       可选   开课类型
     * majNOs        必需   可选专业编号(多个) --> limitMajor  注意：不指定代表所有专业可选
     * depIds        必需   可选学部Id(多个)   --> limitDep    注意：不指定代表所有学部可选
     * graIds        必需   可选年级Id(多个)   --> limitGrade  注意：不指定代表所有年级可选
     * claIds        必需   可选班级Id(多个)   --> limitCla    注意：不指定代表所有班级可选
     * banClaIds     必需   禁选班级Id(多个)   --> banCla      注意：不指定代表所有班级可选
     * weekSched     必需   周课表(按位字符化) --> weekSchedule
	 * couExplain    可选   课程说明
     *
     * 出错返回：{"success":false,"message":"错误信息"}
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
