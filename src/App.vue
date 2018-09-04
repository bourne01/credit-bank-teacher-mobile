<template>
	<div id="app">
		<transition>
			<keep-alive>
				<router-view  v-if="$route.meta.keepAlive"></router-view>
			</keep-alive>
		</transition>
		<transition>
			<router-view v-if="!$route.meta.keepAlive"></router-view>
		</transition>
	</div>
</template>

<script>
export default {
	name: 'app',
	mounted(){
		/**@function 兼容本程序在PC浏览器上可用，最终将是375*667宽高显示 */
		setTimeout(() => {
			let isPC = sessionStorage.getItem('IsPC');
			console.log('......')
			if(isPC == 'Yes'){//修复底部导航条
				let navBar = document.querySelector('#nav-bar');
				navBar.style.position = 'relative';
			}
		}, 200);    
	}
}
</script>

<style lang="less">
	@import '~vux/src/styles/reset.less';

	body {
	//background-color: #fbf9fe;
		font-family: 'PingFang-SC-Medium';
		height: 100%;
		overflow: hidden;
	}
</style>
