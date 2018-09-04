/** 学籍变更Log */

    /** 学号         */ private String    stuNO     ;
    /** 姓名         */ private String    stuName   ;
    /** 性别         */ private String    stuSex    ;
    /** 年级         */ private Integer   grade_id  ;
    /** 专业         */ private Integer   major_id  ;
    /** 班级Id       */ private String    claId     ;
    /** 班级编号     */ private String    claNO     ;
    /** 班级名称     */ private String    claName   ;
    /** 变更记录Id   */ private Integer   autoId    ;
    /** 学生Id       */ private Integer   stuId     ;
    /** 变更时间     */ private Timestamp time      ;
    /** 操作者       */ private Integer   thrId     ;
    /** 操作者姓名   */ private String    thrName   ;
    /** 变更字段     */ private Integer   field     ;
    /** 旧的内容     */ private String    oldContent;
    /** 新的内容     */ private String    newContent;
    /** 变更字段名称 */ private String    fieldNm   ;

    /** 排序   */ private Byte    order;
    /** 年级段 */ private Integer grade;

    //==================================================================================================================
    // 查询 -- 按单次变更分组(多字段)
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询 -- 按单次变更分组(多字段)
     * 使用者：普通教师
     *
     * URL：public/stuInfLog!queryG.action
     *
     * 参数：
     * start      可选   记录开始位置
     * limit      可选   获取记录数量
     * stuId      可选   学生Id
     * grade_id   可选   年级编号
     * major_id   可选   专业编号
     * claName    可选   班级名称(模糊匹配)
     * stuNO      可选   学号(模糊匹配)
     * stuName    可选   姓名(模糊匹配)
     * thrName    可选   操作者姓名(模糊匹配)
     * order      可选   按“变更时间”排序：默认不排序、1=从小到大、2=从大到小
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_StuInfLogGExt.jsonOut]}
     *
     */

    //==================================================================================================================
    // 查询 -- 学籍变更明细
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询 -- 学籍变更明细
     * 使用者：普通教师
     *
     * URL：public/stuInfLog!queryD.action
     *
     * 参数：
     * autoId   必需   变更记录Id
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"dataList":[V_StuInfLogD]}
     *
     */

    //==================================================================================================================
