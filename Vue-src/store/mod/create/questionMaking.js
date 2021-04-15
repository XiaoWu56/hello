export default{
    name: 'questionMaking',
    state: {
        sendNum: 0,
        oneForm: {},
            // id: -1,
            // tUser_id: 20,
            // publishDate: '',
            // endDate: '',
            // status: '',
            // name: '新表单',
            // coverImage: '',
            // content: '提示语',
            // btnCss: '',
            // sendString: '',
            // showNum: '',
            // limitTime: '',
            // isAutoSave: '',
            // isOpen: '',
            // isTop: '',
            // isLike: '',
            // isDelete: '',
            // icon: ''
        answerData: {},//{id:"", 543:"我在"}

        imgs: [
            {url:'https://gd-pub.jinshujufiles.com/hi/20190429173929_b3353b@hixlarge',bg:'https://gd-pub.jinshujufiles.com/hi/20190510153137_c7c653@hixlarge'},
            {url:'https://gd-pub.jinshujufiles.com/hi/20190801194053_8455e5@hixlarge',bg:'https://gd-pub.jinshujufiles.com/hi/20191206150603_537ef9@hixlarge'},
            {url:'https://gd-pub.jinshujufiles.com/hi/20201126172037_91edaf@hixlarge',bg:'https://gd-pub.jinshujufiles.com/bgi/20201126165919_a2f8db'},
            {url:'https://gd-pub.jinshujufiles.com/hi/20200421124742_34bbbc@hixlarge',bg:'https://gd-pub.jinshujufiles.com/hi/20191206150603_537ef9@hixlarge'},
            {url:'https://gd-pub.jinshujufiles.com/hi/20190429172922_332985@hixlarge',bg:'https://gd-pub.jinshujufiles.com/bgi/20201126165919_a2f8db'},
            {url:'https://gd-pub.jinshujufiles.com/hi/20200423110915_41a1c6@hixlarge',bg:'https://gd-pub.jinshujufiles.com/hi/20191206150603_537ef9@hixlarge'},
        ]
    },
    getters: {
        getOneForm(state){
            return state.oneForm;
        },
        getSendNum(state){
            return state.sendNum;
        },
        getAnswerData(state){
            return state.answerData;
        }
    },
    mutations: {
        setAnswerData(state,data) {
            state.answerData[data.num] = data.answer;
        },
        setSendNum(state,num){
            state.sendNum = num;
        },
        setForm(state,data){
            state.oneForm = data;
            // state.newFormQuestiona=[]
        },
        setFormid(state, id){
            state.oneForm.id = id;   
        },
        setFormname(state, name){
            state.oneForm.name = name;   
        },
        setFormcoverImage(state, num){
            state.oneForm.coverImage = state.imgs[num-1];   
        },
        setFormcontent(state, content){
            state.oneForm.content = content;   
        },
        setFormbtnCss(state, btnCss){
            state.oneForm.btnCss = btnCss;   
        },
        setFormshowNum(state){
            state.oneForm.showNum = state.oneForm.showNum==1?0:1;    
        },
        setFormlimitTime(state, limitTime){
            state.oneForm.limitTime = limitTime;   
        },
        setFormisAutoSave(state, isAutoSave){
            state.oneForm.name = isAutoSave;   
        },
        setFormisOpen(state){
            state.oneForm.isOpen = state.oneForm.isOpen==1?0:1;   
        },
        setFormisTop(state, isTop){
            state.oneForm.isTop = isTop;   
        },
        setFormisLike(state, isLike){
            state.oneForm.isLike = isLike;   
        },
        setFormisDelete(state, isDelete){
            state.oneForm.isDelete = isDelete;   
        },
        setFormicon(state, icon){
            state.oneForm.icon = icon;   
        }
    }
}