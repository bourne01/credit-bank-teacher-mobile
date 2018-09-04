/** 考卷查询 -- 考试班 */

	/** 考卷Id     */ private Integer pprId      ;
	/** 考试批次Id */ private Integer batId      ;
	/** 课程Id     */ private Integer couId      ;
	/** 考卷名称   */ private String  pprName    ;
	/** 记录状态   */ private Byte    pprState   ;
	/** 考卷文件名 */ private String  fileName   ;
	/** 考试方式   */ private Byte    examMode   ;
	/** 试卷形式   */ private Byte    paperForm  ;
	/** 承担单位   */ private Integer rshId      ;
	/** 考试时长   */ private Integer timeLong   ;
	/** 可分时段   */ private Byte    timeNum    ;
	/** 并班系数   */ private Byte    merge      ;
	/** 监考系数   */ private Byte    prtNum     ;
	/** 考试任务Id */ private Integer taskId     ;
	/** 绑定行政班 */ private Integer claId      ;
	/** 考试班Id   */ private Integer exmClaId   ;
	/** 考试班名称 */ private String  exmClaName ;
	/** 考生人数   */ private Short   examStuNum ;
	/** 排考Id     */ private Integer arrId      ;
	/** 考试班状态 */ private Byte    exmClaState;
	/** 考试时段Id */ private Integer arrTimeId  ;
	/** 考场Id     */ private Integer exmRomId   ;
	/** 时段名称   */ private String  arrTimeName;
	/** 场地Id     */ private Integer claRomId   ;
	/** 场地名称   */ private String  claRomName ;
	/** 教学楼     */ private Integer buiId      ;
	/** 教学楼名称 */ private String  buiName    ;
    
    //附加字段
    /** 考卷指定时段Id集   */ private String pprTimeIds   ;
    /** 考卷指定时段名称集 */ private String pprTimeNms   ;
    /** 考卷开始时间集     */ private String pprStartTimes;
    /** 考卷考试时长集     */ private String pprTimeLongs ;
    /** 班级绑定考场Id集   */ private String claExmRomIds ;
    /** 班级绑定考场名称集 */ private String claExmRomNms ;

    /** 排序字段     */ private String[] orderFd; //排序字段的名称，倒序前面加“@”，可以多个
    /** 考卷Id(多个) */ private int[]    pprIds;

    //==================================================================================================================
    // 查询
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询
     * 使用者：
     *
     * URL：pprExmCla!query.action
     *
     * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * pprId        可选   考卷Id
	 * batId        可选   考试批次Id
	 * couId        可选   课程Id
	 * pprName      可选   考卷名称
	 * pprState     可选   记录状态 2正常(默认)、3关闭、4历史
	 * fileName     可选   考卷文件名
	 * examMode     可选   考试方式  T_Code.F_Type=49 1闭卷(默认)、2开卷
	 * paperForm    可选   试卷形式  T_Code.F_Type=50 1纸制(默认)、2电子、3第三方
	 * rshId        可选   承担单位
	 * timeLong     可选   考试时长
	 * timeNum      可选   可分时段
	 * merge        可选   并班系数 同一考场最多允许几个班在一起，默认1
	 * prtNum       可选   监考系数 同一考场需要几个监考考师，默认1
	 * taskId       可选   考试任务Id
	 * claId        可选   绑定行政班 默认0表示不绑定，大于0为行政班Id
	 * exmClaId     可选   考试班Id
	 * exmClaName   可选   考试班名称
	 * examStuNum   可选   考生人数
	 * arrId        可选   排考Id(-1代表没排考记录)
	 * exmClaState  可选   记录状态  2正常(默认)、3关闭、4历史
	 * arrTimeId    可选   考试时段Id
	 * exmRomId     可选   考场Id
	 * arrTimeName  可选   时段名称
	 * claRomId     可选   场地Id
	 * claRomName   可选   场地名称
	 * buiId        可选   教学楼
	 * buiName      可选   教学楼名称
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[Q_PprExmCla]}
     *
     * 注意：需要保证，查询范围是属于同一考试批次(batId)，否则返回的“班级指定考场数据”可能会出错
     *
     */

    //==================================================================================================================
