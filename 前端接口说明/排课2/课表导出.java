/** 课表导出 */

    /** 排课计划Id */ private Integer scpId;
    /** 教师Id     */ private Integer thrId;
    /** 行政班Id   */ private Integer claId;
    /** 教学班Id   */ private Integer tccId;
    /** 场地Id     */ private Integer romId;
    /** 课程Id     */ private Integer couId;

    /** 教师Id组    */ private String thrIds;
    /** 行政班Id组  */ private String claIds;
    /** 教学班Id组  */ private String tccIds;
    /** 场地Id组    */ private String romIds;
    /** 课程Id组    */ private String couIds;

    /** 视角     */ private Integer angle  ; //1=教师、2=行政班、3=教学班、4=场地
    /** 类型     */ private Byte    type   ;
    /** 一行一条 */ private Byte    horShow;

    //==================================================================================================================
    //导出：单一课表
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：导出单一课表
     * 使用者：+ 部门负责人
     *
     * URL：schedExport!oneSch.action
     *
     * 参数：
     * scpId     必需   排课主计划Id
     * claId     4选1   行政班Id
     * tccId     4选1   教学班Id
     * thrId     4选1   教师Id
     * romId     4选1   场地Id
     * horShow   可选   0(默认)=旧格式、1=一条课表一行
     *
     * 4选1参数，优先顺序为：claId > tccId > thrId > romId
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     *
     */

    //==================================================================================================================
    //导出：匹量课表 -- 条形布局 -- 只包含有课表的成员
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：导出匹量课表 -- 条形布局 -- 只包含有课表的成员
     * 使用者：+ 部门负责人(自己负责的部门)
     *
     * URL：schedExport!mutilSch.action
     *
     * 参数：
     * scpId      必需   排课主计划Id
     * thrIds     可选   教师Id组   多个Id用“,”隔开
     * couIds     可选   课程Id组   多个Id用“,”隔开
     * claIds     可选   行政班Id组 多个Id用“,”隔开
     * tccIds     可选   教学班Id组 多个Id用“,”隔开
     * romIds     可选   场所Id组   多个Id用“,”隔开
     * angle      可选   0(默认)=所有视角、1=教师、2=行政班、3=教学班、4=场地
     * type       可选   1条形课表(默认)、3方形课表
     * horShow    可选   0(默认)=旧格式、1=一条课表一行
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     *
     */

    //==================================================================================================================
