/** 确认开课 */

    /** 待选课Id(多) */ private int[] autoIds;

    /** 待选课Id       */ private Integer  autoId;
    /** 任课教师Id(多) */ private int[]    thrIds;
    /** 总课时    (多) */ private short[]  lesNums;
    /** 课程学分  (多) */ private double[] credits;

    //==================================================================================================================
    // 确认开班
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：确认开班
     * 使用者：高级用户
     *
     * URL：auditSelCou!auditOK.action
     *
     * 参数：
     * autoIds   必需   待选课程Id(可以多个)
     *
     * 出错返回：{"success":false,"message":"错误信息"}
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     * 说明：当前状态不能为“4完成”，学员人数不能低于下限，必需要有班级信息(学员将正式加入该班)
     *
     */

    //==================================================================================================================
    // 确认开班2 -- 增加多任课信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：确认开班2 -- 增加多任课信息
     * 使用者：高级用户
     *
     * URL：auditSelCou!auditOK2.action
     *
     * 参数：
     * autoId    必需   待选课Id(单个)
     * thrIds    必需   任课教师(可多个)
     * lesNums   必需   总课时  (可多个)
     * credits   必需   课程学分(可多个)
     *
     * 出错返回：{"success":false,"message":"错误信息"}
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     * 说明：当前状态不能为“4完成”，学员人数不能低于下限，必需要有班级信息(学员将正式加入该班)
     *
     */

    //==================================================================================================================
    // 取消开班
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：取消开班
     * 使用者：高级用户
     *
     * URL：auditSelCou!unAudit.action
     *
     * 参数：
     * autoId   必需   待选课程Id
     *
     * 出错返回：{"success":false,"message":"错误信息"}
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     * 说明：当前状态不能为“4完成”，学员人数不能低于下限，必需要有班级信息(学员将正式加入该班)
     *
     */

    //==================================================================================================================
