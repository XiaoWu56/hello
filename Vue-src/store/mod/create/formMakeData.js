export default{
    name: 'formMakeData',
    state: {
        formQuestion: [],
        formQuestiona: [],

        typeId: '0',
        
        testb: [],
        //showSet当前需显示的题目设置当前需显示的题目设置序号
        showSet: -1,
        formQuestionA:{} 
    },
    getters: {
        getFormQuestion(state){
            return state.formQuestion;
        },
        getFormQuestiona(state){
            return state.formQuestiona;
        },
        getFormQuestionA(state){
            return state.formQuestionA;
        },
        getFormQuestionB(state){
            return state.formQuestionA;
        },
        getShowSet(state){
            return state.showSet;
        },
        getTypeId(state){
            return state.typeId;
        }
    },
    mutations: {//代码写法: .commit
        addTypeId(state, typeId){
            state.typeId = typeId;
        },
        delTypeId(state){
            state.typeId = '0';
        },
        newFormQuestiona(state){
            state.formQuestiona=[]
        },
        //方法作用：添加题目
        
        addFormQuestiona(state, data){
            //步骤：添加，标记当前需显示的题目设置
            //代码写法：数组splice(位置， 改变数量， 数据)
            state.formQuestiona.splice(state.formQuestiona.length, 0, data.model);
            state.showSet = state.formQuestiona.length-1;
        },
        setFormQuestiona(state, data){
            // state.showSet = data.length-1;
            state.formQuestiona = data;
        },
        addFormQuestionA(state, data){  
            state.formQuestionA[data.index] = data.model;
            state.showSet = data.index;
        },
        //方法作用：修改题目，如变动位置
        changeFormQuestion(state, data){
            //步骤：  
            //titleNum题目位置，titleOpt题目操作（-1为上, 2下, 1复制, 0删除）
            //注意事项：data.titleNum-data.titleOpt方法splice括号内无效，未知原因？data.titleNum+-data.titleOpt可行
            // state.formQuestion.splice(data.titleNum+data.titleOpt, 0, state.formQuestion[data.titleNum])
            state.formQuestiona.splice(data.titleNum+data.titleOpt, 0, state.formQuestiona[data.titleNum])
            // state.showSet = data.titleNum+data.titleOpt;
            if(data.titleOpt==-1){//针对删除
                state.showSet = state.showSet-1;
            }else if(data.titleOpt==-2){//针对删除
                state.showSet = state.showSet+1;
            }else if(data.titleOpt==1){//针对复制
                state.showSet = state.showSet+1;
            }
        },
        //方法作用：删除题目
        delFormQuestion(state, titleNum){
            //splice(this.i, 1)-(位置， 改变数量)
            // state.formQuestion.splice(titleNum, 1)
            state.formQuestiona.splice(titleNum, 1)
            state.showSet = -1;
        },
        changeShowSet(state, titleNum){
            state.showSet = titleNum;
        }
    },
    actions: {//代码写法: .dispatch
        getAddFormQuestion(context, typeId){ 
            //方法作用：向新建表单添加题目数据（含题目名，提示等）
            //步骤：点击题型，题目数组加值
            context.commit('addFormQuestionA', typeId.data)
            context.commit('addFormQuestion', typeId.typeId)  
        },
        getAddFormQuestionA(context, data){
            context.commit('addFormQuestionA', data)
        },
        //方法作用：题目变动顺序
        getChangeFormQuestion(context, data){
            //步骤：复制添加-删除(细节，删除时的顺序不是原来的)
            //数据：data:{titleNum, titleOpt}
            //注意事项():titleOpt为标识上下，-1为上, 2下, 1复制, 0删除
            //注意事项(改改改):注意vuex的action传递多参数要封装成Object,接收用一变量data
            if(data.titleOpt!=0){
                context.commit('changeFormQuestion', data)
            }
            if(data.titleOpt==-1){
                context.commit('delFormQuestion', data.titleNum-data.titleOpt)
            }else if(data.titleOpt==2||data.titleOpt==0){
                context.commit('delFormQuestion', data.titleNum)
            }
                
        }
    }
}