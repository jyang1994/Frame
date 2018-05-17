import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import home from '@/components/home'
import add from '@/components/add'
import edit from '@/components/edit'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path:"/",
      name:  "home",
      component:home
    } ,
    {
      path:"/new",
      name:"add",
      component:add,
    },
    {
      path:"/edit/:id",
      name:"edit",
      component:edit,
    }
  ]
})
