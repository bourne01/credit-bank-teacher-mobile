    /** 成员Id   */ public String id;   //[周几][第几节][Id组1,Id组2...]
    /** 成员名称 */ public String name; //[周几][第几节][名称组1,名称组2...]
    /** 重复系数 */ public String rep;  //周一(1-8节)+周二(1-8节)...  值＝对应位置排了几节课
    
    /** 并班系数(由外部注入) */ public byte  merge  = 1;   //目前只有场地该值有效
    /** 人数上限(由外部注入) */ public short manMax = 999; //目前只有场地该值有效 -- 由于教学班人数可能未定，该项目前无做用

	//【id】--- 教师Id、课程Id、行政班Id、教学班Id、场地Id、type、schedId、scpSId、scpDId、scmGrp
	//type      课表类型       1来自排课方案(默认)、2来自任课表、3即时课表
	//schedId   排课结果Id
	//scpSId    排课方案Id     如果type不是1，则没有意义
	//scpDId    排课细计划Id   如果type不是1，则没有意义
	//scmGrp    方案分组       如果type不是1，则没有意义

	//【name】--- 教师、课程、行政班、教学班、场地
    
	//【rep】--- 0=该位置没有排课、1=有1节、大于1就是有冲突；场地还要考虑并班系数