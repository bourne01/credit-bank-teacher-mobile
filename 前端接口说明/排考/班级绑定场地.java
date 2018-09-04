/** 班级绑定场地(考场) */

    /** 班级Id     */ private Integer claId    ;
    /** 绑定场地Id */ private Integer bindRomId;
    /** 座位数量   */ private Short   seatNum  ;
    /** 并班系数   */ private Byte    merge    ; //1不允许并班(默认)，大于2为最多允许几个班，最大9；这个班指的是考试班

    /** 班级编号           */ private String  claNO            ;
    /** 班级名称           */ private String  claName          ;
    /** 年级代码           */ private Integer grade            ; //代码类型(35)
    /** 专业代码           */ private Integer major            ; //代码类型(3)
    /** 校区Id             */ private Integer camId            ;
    /** 学部Id             */ private Integer depId            ;
    /** 固定教室Id         */ private Integer fixClaRomId      ;
    /** 固定教室名称       */ private String  fixClaRomName    ;
    /** 绑定场地Id         */ private String  bindClaRomId     ; //多个用“,”隔开
    /** 绑定场地座位数     */ private String  bindClaRomSeatNum; //多个用“,”隔开
    /** 绑定场地并班系数   */ private String  bindClaRomMerge  ; //多个用“,”隔开
    /** 绑定场地名称       */ private String  bindClaRomName   ; //多个用“,”隔开
    /** 绑定场地教学楼Id   */ private String  bindClaRomBuiId  ; //多个用“,”隔开
    /** 绑定场地教学楼名称 */ private String  bindClaRomBuiName; //多个用“,”隔开

    /** 班级类型 */ private Byte    claType      ; //代码类型(52) 1行政班、3升学班、4就业班
    /** 班主任Id */ private Integer masterId     ;
    /** 男生数   */ private Integer boyCount     ;
    /** 女生数   */ private Integer girlCount    ;
    /** 入学人数 */ private Integer startManCount;
    /** 入学成绩 */ private Double  startResult  ;
    /** 开班日期 */ private Date    joinDate     ;
    /** 结束日期 */ private Date    gradDate     ;
    /** 是否在校 */ private Byte    inSchool     ;
    /** 班级状态 */ private Byte    claState     ;
    /** 备注     */ private String  remark       ;
    /** 校区名称 */ private String  camName      ;
    /** 学部名称 */ private String  depName      ;
    /** 教师编号 */ private String  thrNO        ;
    /** 教师姓名 */ private String  thrName      ;
    /** 教师性别 */ private String  thrSex       ;

    /** 排序字段     */ private String[] orderFd  ; //排序字段的名称，倒序前面加“@”，可以多个
    /** 班级Id(多个) */ private int[]    claIds   ;
    /** 合并座位     */ private Byte     mergeSeat;

    //==================================================================================================================
    // 查询
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询
     * 使用者：
     *
     * URL：claBindRom!query.action
     *
     * 参数
     * start      可选   记录开始位置
     * limit      可选   获取记录数量
     * claId      可选   班级Id
     * bindRomId  可选   绑定场地Id
     * seatNum    可选   座位数量
     * merge      可选   并班系数 1不允许并班(默认)，大于2为最多允许几个班，最大99；这个班指的是考试班
     * orderFd    可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[ClaBindRoom]}
     *
     */

    //==================================================================================================================
    // 查询2 -- 查询详细(只含有绑定记录的班级)
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2 -- 查询详细(只含有绑定记录的班级)
     * 使用者：教师
     *
     * URL：claBindRom!query2.action
     *
     * 参数
     * start              可选   记录开始位置
     * limit              可选   获取记录数量
     * claId              可选   班级Id
     * claNO              可选   班级编号
     * claName            可选   班级名称
     * grade              可选   年级代码 代码类型(35)
     * major              可选   专业代码 代码类型(3)
     * camId              可选   校区Id
     * depId              可选   学部Id
     * fixClaRomId        可选   固定教室Id
     * fixClaRomName      可选   固定教室名称
     * bindClaRomId       可选   绑定场地Id
     * bindClaRomSeatNum  可选   绑定场地座位数
     * bindClaRomMerge    可选   绑定场地并班系数
     * bindClaRomName     可选   绑定场地名称
     * bindClaRomBuiId    可选   绑定场地教学楼Id
     * bindClaRomBuiName  可选   绑定场地教学楼名称
     * orderFd            可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_ClaBindRoom]}
     *
     */

    //==================================================================================================================
    // 查询3 -- 更详细的数据(含所有班级，比查询2返回更多的信息)
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询3 -- 更详细的数据(含所有班级，比查询2返回更多的信息)
     * 使用者：教师
     *
     * URL：claBindRom!query3.action
     *
     * 参数
     * start              可选   记录开始位置
     * limit              可选   获取记录数量
     * claId              可选   班级Id
     * claType            可选   班级类型 代码类型(52) 1行政班、3升学班、4就业班
     * claNO              可选   班级编号
     * claName            可选   班级名称
     * grade              可选   年级代码 代码类型(35)
     * major              可选   专业代码 代码类型(3)
     * camId              可选   校区Id
     * depId              可选   学部Id
     * fixClaRomId        可选   固定教室Id
     * masterId           可选   班主任Id
     * inSchool           可选   是否在校
     * claState           可选   班级状态
     * remark             可选   备注
     * fixClaRomName      可选   固定教室名称
     * camName            可选   校区名称
     * depName            可选   学部名称
     * thrNO              可选   教师编号
     * thrName            可选   教师姓名
     * thrSex             可选   教师性别
     * bindClaRomId       可选   绑定场地Id 多个用“,”隔开
     * bindClaRomSeatNum  可选   绑定场地座位数 多个用“,”隔开
     * bindClaRomMerge    可选   绑定场地并班系数 多个用“,”隔开
     * bindClaRomName     可选   绑定场地名称 多个用“,”隔开
     * bindClaRomBuiId    可选   绑定场地教学楼Id 多个用“,”隔开
     * bindClaRomBuiName  可选   绑定场地教学楼名称 多个用“,”隔开
     * orderFd            可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_ClaBindRoom3]}
     *
     */

    //==================================================================================================================
    // 新增
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：高级用户
     *
     * URL：claBindRom!newRec.action
     *
     * 参数
     * claId      必需   班级Id
     * bindRomId  必需   绑定场地Id
     * seatNum    可选   座位数量
     * merge      可选   并班系数 1不允许并班(默认)，大于2为最多允许几个班，最大9；这个班指的是考试班
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
    // 多个班级互相共享教室做考场
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：多个班级互相共享教室做考场
     * 使用者：高级用户
     *
     * URL：claBindRom!unionCla.action
     *
     * 参数
     * claIds     必需   班级Id(多个)
     * mergeSeat  可选   合并座位：几个座位合并成一个，最大值9；默认1＝不合并
     * merge      可选   并班系数 1不允许并班(默认)，大于2为最多允许几个班，最大9；这个班指的是考试班
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
    // 修改
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：修改
     * 使用者：高级用户
     *
     * URL：claBindRom!edit.action
     *
     * 参数
     * claId      必需   班级Id
     * bindRomId  必需   绑定场地Id
     * seatNum    可选   座位数量
     * merge      可选   并班系数 1不允许并班(默认)，大于2为最多允许几个班，最大99；这个班指的是考试班
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
     * URL：claBindRom!del.action
     *
     * 参数
     * claId      必需   班级Id
     * bindRomId  必需   绑定场地Id
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
