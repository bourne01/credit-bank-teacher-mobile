import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

export default new VueRouter({
  routes: [
    {
      	path: '/',
      	redirect: 'startup',      
    },
    {
      	path: '/startup',
      	name: 'Startup',
		component: resolve => require(['../components/startup'],resolve),
		meta:{keepAlive: false},	
    },
    {
      	path: '/login',
      	name: 'Login',
		component: resolve => require(['../components/user/login'],resolve),
		meta:{keepAlive: true},	
    },
    {
      	path:'/home/',
      	name:'Home',
		component:resolve => require(['../components/home/home'],resolve),
		meta:{keepAlive: true},	
    },
	/* {
		path:'/me',
		name:'Me',
		component:resolve => require(['../components/home/me'],resolve),
		meta:{keepAlive: true},	
	}, */
	{
		path:'/my-schedule',
		name:'MySchedule',
		component:resolve => require(['../components/my-schedule/my-schedule'],resolve),
	},
	{
		path:'/record-score',
		name:'RecordScore',
		component:resolve => require(['../components/record-score/record-score'],resolve),
	},	
	/* {
		path:'/find-password',
		name:'FindPassword',
		component:resolve => require(['../components/user/find-password'],resolve),
		meta:{keepAlive: true},	
	},
	{
		path:'/register',
		name:'Register',
		component:resolve => require(['../components/user/register'],resolve),
		meta:{keepAlive: true},	
	}, */
	{
		path:'/headline-list',
		name:'HeadlineList',
		component:resolve => require(['../components/home/capmus-news/headline-list.vue'],resolve),
		meta:{keepAlive: true},	
	},
	{
		path:'/news-detail',
		name:'NewsDetail',
		component:resolve => require(['../components/home/capmus-news/news-detail.vue'],resolve),
		
	},
	{
		path:'/course-list',
		name:'CourseList',
		component:resolve => require(['../components/record-score/course-list'],resolve),
		meta:{keepAlive: true},	
	},
	{	
		path:'/page-not-found',
		name:'PageNotFound',
		component:resolve => require(['../components/page-not-found'],resolve)
	},	
  ]
})
