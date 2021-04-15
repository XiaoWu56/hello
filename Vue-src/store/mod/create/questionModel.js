export default{
    name: 'questionModel',
    state: {
        oneFormModel:{
            id: -1,
            tUser_id: 20,
            publishDate: '',
            endDate: '',
            status: '',
            name: '新表单',
            coverImage: '',
            content: '提示语',
            btnCss: '',
            sendString: '',
            showNum: '',
            limitTime: '',
            isAutoSave: '',
            isOpen: '',
            isTop: '',
            isLike: '',
            isDelete: '',
            icon: ''
        },
        types : [
            {
                title:'选择题', 
                titledetail: [
                    {id: 'A1', name: '单选题'},
                    {id: 'A2', name: '多选题'},
                    {id: 'A3', name: '下拉选择'},
                    {id: 'A4', name: '多级下拉'},
                    {id: 'A5', name: '图片单选'},
                    {id: 'A6', name: '图片多选'},
                    {id: 'A7', name: '矩阵单选'}]
            },
            {
                title:'填空简答题', 
                titledetail: [
                    {id: 'B1', name: '填空题'},
                    {id: 'B2', name: '简答题'},
                    {id: 'B3', name: '数字'}]
            },
            {
                title:'评分排序题', 
                titledetail: [
                    {id: 'C1', name: '评分题'},
                    {id: 'C2', name: 'NPS题'},
                    {id: 'C3', name: '排序题'},
                    {id: 'C4', name: '计算'}]
            }
        ],
        models: {
            // "A1": {
            //     id: 'A1',
            //     type: "单选题",
            //     model: "OptionB",
            //     title: {text: "单选题"},
            //     tip: {text: ""},
            //     data: [
            //         //{顺序， 种类（单选/多选）， 默认选， 可见项， 文本}
            //         {type: "radio", isClick: false, text: "选项1" },
            //         {type: "radio", isClick: false, text: "选项2" },
            //         {type: "radio", isClick: false, text: "选项3" },
            //         {type: "radio", isClick: false, text: "选项4" },
            //     ]
            // }, 
            "A1": {
                id: -1,
                tQuestion_id: -1,
                name: "单选题",
                type: 'A1',
                model: [
                    //{顺序， 种类（单选/多选）， 默认选， 可见项， 文本}
                    {type: "radio", isClick: false, text: "选项1" },
                    {type: "radio", isClick: false, text: "选项2" },
                    {type: "radio", isClick: false, text: "选项3" },
                    {type: "radio", isClick: false, text: "选项4" },
                ]
            },
            "A2": {
                id: -1,
                tQuestion_id: -1,
                name: "多选题",
                type: 'A2',
                model: [
                    {type: "checkbox", isClick: false, text: "选项1" },
                    {type: "checkbox", isClick: false, text: "选项2" },
                    {type: "checkbox", isClick: false, text: "选项3" },
                ]
            },
            "A3": {
                id: -1,
                tQuestion_id: -1,
                name: "下拉选择",
                type: 'A3',
                model: [
                    //[//这里放入数组，因题目模板与多级下拉共用F 这样关系交杂，模板不清晰直接
                    {type: "radio",text: "下拉选项1" },
                    {type: "radio",text: "下拉选项2" },
                    //]
                ]
            },
            "A4": {
                id: -1,
                tQuestion_id: -1,
                name: "下拉选择",
                type: 'A4',
                model: [
                    [
                        {type: "radio",text: "下拉选项1" },
                        {type: "radio",text: "下拉选项2" }
                    ],
                    [
                        {type: "radio",text: "下拉选项1" },
                        {type: "radio",text: "下拉选项2" }
                    ]
                ]
            },
            "A5": {
                id: -1,
                tQuestion_id: -1,
                name: "图片单选",
                type: 'A5',
                model: [
                    //{顺序， 种类（单选/多选）， 默认选， 可见项， 文本}
                    {type: "radio", isClick: false, text: "图片单选1", picSrc: "#" },
                    {type: "radio", isClick: false, text: "图片单选2", picSrc: "#" },
                    {type: "radio", isClick: false, text: "图片单选3", picSrc: "#" }
                ]
            }, 
            "A6": {
                id: -1,
                tQuestion_id: -1,
                name: "图片多选",
                type: 'A6',
                model: [
                    //{顺序， 种类（单选/多选）， 默认选， 可见项， 文本}
                    {type: "checkbox", isClick: false, text: "图片多选1", picSrc: "#" },
                    {type: "checkbox", isClick: false, text: "图片多选2", picSrc: "#" },
                ]
            },
            "A7": {
                id: -1,
                tQuestion_id: -1,
                name: "矩阵单选",
                type: 'A7',
                model: {
                    questions: [
                        {text: "题目1"},
                        {text: "题目2"},
                        {text: "题目3"}
                    ],
                    options: [
                        { position: 1, text: "选项1"},
                        { position: 2, text: "选项2"}
                        
                    ]
                }
                    
            },
            "B1": {
                id: -1,
                tQuestion_id: -1,
                name: "填空题",
                type: 'B1',
                model: [
                    { text: "填空题"}
                ]
            },
        }    
    },
    getters: {
        getOneFormModel(state){
            return state.oneFormModel;
        },
        getTypes(state){
            return state.types;
        },
        getModels(state){
            return state.models;
        }
    },
}