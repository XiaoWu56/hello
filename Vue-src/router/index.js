import Vue from 'vue'
import VueRouter from 'vue-router'

import login from '@/views/login.vue'
import home from '@/views/home.vue'
import form from '@/views/form.vue'
import data from '@/views/data.vue'
import write from '@/views/write.vue'
import see from '@/views/see.vue'

import MainForms from '@/components/home/main/MainForms'
import MainLike from '@/components/home/main/MainLike'
import MainDel from '@/components/home/main/MainDel'
import ChangeFolder from '@/components/home/common/ChangeFolder'
import ChangeFormFace from '@/components/home/common/ChangeFormFace'

import create from '@/views/form/create.vue'
import set from '@/views/form/set.vue'
import send from '@/views/form/send.vue'
import QuestionChange from '@/components/form/create/common/QuestionChange'
import FormChange from '@/components/form/create/common/FormChange'

import dataInfo from '@/views/data/dataInfo.vue'
import dataTable from '@/views/data/dataTable.vue'
import dataPic from '@/views/data/dataPic.vue'
Vue.use(VueRouter)
const homeSetFormRoute = [
  // {
  //   path: '/changeFolder',
  //   name: 'ChangeFolder',
  //   component: ChangeFolder
  // },
  // {
  //   path: '/changeFormFace',
  //   name: 'ChangeFormFace',
  //   component: ChangeFormFace
  // }
]
const homeChildRoute = [
  {
    path: '/',
    name: 'MainForms',
    component: MainForms,
    // children: homeSetFormRoute
  },
  {
    path: '/mainLike',
    name: 'MainLike',
    component: MainLike
  },
  {
    path: '/mainDel',
    name: 'MainDel',
    component: MainDel
  }
]
const formChildRoute = [
  {
    path: '/',
    name: 'create',
    component: create,
    children: [
        {
          path: '/',
          name: 'QuestionChange',
          component: QuestionChange,
        },
        {
          path: 'formChange',
          name: 'FormChange',
          component: FormChange,
        }
    ]
  },
  {
    path: 'set',
    name: 'set',
    component: set
  },
  {
    path: 'send',
    name: 'send',
    component: send
  }
]
const dataChildRoute = [
  {
    path: '/',
    name: 'dataInfo',
    component: dataInfo,
  },
  {
    path: 'dataTable',
    name: 'dataTable',
    component: dataTable
  },
  {
    path: 'dataPic',
    name: 'dataPic',
    component: dataPic
  }
]
const routes = [
  {
    path: '/',
    name: 'home',
    component: home,
    children: homeChildRoute
  },
  {
    path: '/login',
    name: 'login',
    component: login,
  },
  {
    path: '/form',
    name: 'form',
    component: form,
    children: formChildRoute
  },
  {
    path: '/data',
    name: 'data',
    component: data,
    children: dataChildRoute
  },
  {
    path: '/write',
    name: 'write',
    component: write
  },
  {
    path: '/see',
    name: 'see',
    component: see
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
}) 

export default router
