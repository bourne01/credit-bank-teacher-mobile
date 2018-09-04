// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import FastClick from 'fastclick'
import  router from './router/index.js'
import App from './App'
/* import { AjaxPlugin,AlertPlugin} from 'vux'
Vue.use(AjaxPlugin)
Vue.use(AlertPlugin) */
import AlertPlugin from 'vux/src/plugins/alert/index.js'
Vue.use(AlertPlugin)
import axios from 'axios'
Vue.prototype.$http = axios
FastClick.attach(document.body);
Vue.config.devtools = true;
Vue.config.productionTip = false;
/* eslint-disable no-new */
new Vue({
  router,
  render: h => h(App),
  data:{
    bus: new Vue()
  }
}).$mount('#app-box')

/**
 * 注册在全局上
 * @param {提示框标题} title 
 * @param {提示信息} content 
 * @param {多少秒后自动关闭} second 
 */
Vue.prototype.$msgbox = function(title,content,second){
  if(!second)
    second = 500;
  this.$vux.alert.show({
    title,
    content
  });
  setTimeout(() => {
    this.$vux.alert.hide();
  }, second);
};