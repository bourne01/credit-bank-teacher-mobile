import java.util.List;


	/** 排课计划Id */ public int  scpId ;
	/** 初始课表   */ public long iniSch;
	/** 课表字典   */ public List<SchedMainInf> mainInf = new ArrayList<SchedMainInf>(); //因为课表信息较多，且复用明显，所以独立出来 
	/** 课表：教师 */ public List<ThrSchedRe> thrSched = new ArrayList<ThrSchedRe>();
	/** 课表：政班 */ public List<ClaSchedRe> claSched = new ArrayList<ClaSchedRe>();
	/** 课表：教班 */ public List<TccSchedRe> tccSched = new ArrayList<TccSchedRe>();
	/** 课表：场地 */ public List<RomSchedRe> romSched = new ArrayList<RomSchedRe>();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ╔═══════╗
	// ║ 成员课表结构 ║
	// ╚═══════╝
	//==================================================================================================================
	// 专用数据类 -- 教师课表
	//------------------------------------------------------------------------------------------------------------------
	public static class ThrSchedRe
	{
		/** 教师Id   */ public int    thrId  ;
		/** 教师编号 */ public String thrNO  ;
		/** 教师姓名 */ public String thrName;
		/** 教师性别 */ public String thrSex ;
		/** 初始课表 */ public long   iniSch ;
		/** 冲突简述 */ public byte[][] rep = new byte[7][8];  //0无冲突、1有冲突
		/** 视角课表 */ public List<SchedIdAndClashInf>[][] angleSched = new ArrayList[7][8];
	}
	
	//==================================================================================================================
	// 专用数据类 -- 行政班课表
	//------------------------------------------------------------------------------------------------------------------
	public static class ClaSchedRe
	{
		/** 行政班Id   */ public int    claId     ;
		/** 行政班编号 */ public String claNO     ;
		/** 行政班名称 */ public String claName   ;
		/** 行政班年级 */ public String claGradeNm;
		/** 行政班专业 */ public String claMajorNm;
		/** 行政班部门 */ public String claDepNm  ;
		/** 初始课表   */ public long   iniSch    ;
		/** 冲突简述   */ public byte[][] rep = new byte[7][8];  //0无冲突、1有冲突
		/** 视角课表   */ public List<SchedIdAndClashInf>[][] angleSched = new ArrayList[7][8];
	}

	//==================================================================================================================
	// 专用数据类 -- 教学班课表
	//------------------------------------------------------------------------------------------------------------------
	public static class TccSchedRe
	{
		/** 教学班Id   */ public int    tccId     ;
		/** 教学班编号 */ public String tccNO     ;
		/** 教学班名称 */ public String tccName   ;
		/** 教学班年级 */ public String tccGradeNm;
		/** 教学班专业 */ public String tccMajorNm;
		/** 教学班部门 */ public String tccDepNm  ;
		/** 初始课表   */ public long   iniSch    ;
		/** 冲突简述   */ public byte[][] rep = new byte[7][8];  //0无冲突、1有冲突
		/** 视角课表   */ public List<SchedIdAndClashInf>[][] angleSched = new ArrayList[7][8];
	}
	
	//==================================================================================================================
	// 专用数据类 -- 场地课表
	//------------------------------------------------------------------------------------------------------------------
	public static class RomSchedRe
	{
		/** 场地Id     */ public int    romId   ;
		/** 场地编号   */ public String romNO   ;
		/** 场地名称   */ public String romName ;
		/** 场地教学楼 */ public String romBuiNm;
		/** 并班系数   */ public byte   romMerge;
		/** 初始课表   */ public long   iniSch  ;
		/** 冲突简述   */ public byte[][] rep = new byte[7][8];  //0无冲突、1有冲突
		/** 视角课表   */ public List<SchedIdAndClashInf>[][] angleSched = new ArrayList[7][8];
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ╔═══════╗
	// ║ 基本数据结构 ║
	// ╚═══════╝
	//==================================================================================================================
	// 课表主要信息
	//------------------------------------------------------------------------------------------------------------------
	public static class SchedMainInf
	{
		public int      schedId = 0;          //排课结果Id
	    public int[]    ids  = new int[9];    //教师Id、课程Id、行政班Id、教学班Id、场地Id、type、scpSId、scpDId、weekH
	    public String[] infs = new String[5]; //教师、课程、行政班、教学班、场地（注：如果 有教学班 没有行政班，则把 教学班名称 同时写入 行政班名称 中)

		//type      课表类型    1来自排课方案(默认)、2来自任课表、3即时课表
		//scpSId    排课方案Id
	    //scpDId    排课细计划Id
		//weekH     排课周
	    
	    public List<Integer> relIds   = null;  //同属一个方案组的其它排课结果Id(不包含自己)，null代表没有
	    public String        weekHInf = null;  //排课周的文字描述信息 
	}
	
	//==================================================================================================================
	// 课表Id + 冲突信息
	//------------------------------------------------------------------------------------------------------------------
	public static class SchedIdAndClashInf
	{
		public int    schedId = 0;           //课表Id（根据这个去 MainInfList 中获取具体内容)
		public byte   reInf   = 0;           //冲突总述：0=无冲突、1=有冲突
	    public byte[] reInf1  = new byte[5]; //初始设置冲突：教师、政班、教班、场地、课程；0=无冲突、1=有冲突、2=与主计划冲突(只出现在课程中)
	    public byte[] reInf2  = new byte[4]; //课表安排冲突：教师、政班、教班、场地；0=无冲突、1=有冲突
	    
	    // 没有冲突则保持为null
		/** 教师冲突详细：有冲突的课表Id */ public Set<Integer> thrReId = null; //0代表与初始课表设置有冲突
		/** 政班冲突详细：有冲突的课表Id */ public Set<Integer> claReId = null; //0代表与初始课表设置有冲突
		/** 教班冲突详细：有冲突的课表Id */ public Set<Integer> tccReId = null; //0代表与初始课表设置有冲突
		/** 场地冲突详细：有冲突的课表Id */ public Set<Integer> romReId = null; //0代表与初始课表设置有冲突
	}
}


	