export default{
    name: 'home',
    // 作用： 放创建文件夹的值

    state:{
        // 作用： 创建文件夹的show
        showMask: false,
        // 作用： 创建表单设置的show
        showMask1: false,
        // 作用： 创建表单预览的show
        showMaskForm: false,
        // 作用： 创建表单设置的[x,y,formid]
        clientInfo: []
    },
    getters: {
        getShowMask(state){
            return state.showMask;
        },
        getShowMask1(state){
            return state.showMask1;
        },
        getShowMaskForm(state){
            return state.showMaskForm;
        },
        getClientInfo(state){
            return state.clientInfo;
        }
    },
    mutations:{
        changeShowMask(state){
            state.showMask = !state.showMask;
        },
        changeShowMask1(state){
            state.showMask1 = !state.showMask1;
        },
        changeShowMaskForm(state){
            state.showMaskForm = !state.showMaskForm;
        },
        addClientInfo(state, data){
            state.clientInfo = data;
        }
    }
}