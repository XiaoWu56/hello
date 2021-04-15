import Vue from 'vue'
import Vuex from 'vuex'
import home from './mod/home/home'
import questionModel from './mod/create/questionModel'
import questionMaking from './mod/create/questionMaking'
import formMakeData from './mod/create/formMakeData'

Vue.use(Vuex)
//ES6规范，因直接使用modCreateState错误，要对应赋值使用，store中没有定义modCreateState，

export default new Vuex.Store({
  state: {
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    home,
    questionModel,
    questionMaking,
    formMakeData
  }
})
