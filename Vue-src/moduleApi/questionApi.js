// axios.defaults.baseURL = "http://localhost:8086";
import axios from 'axios'
const http = axios.create({ baseURL: 'http://localhost:8086' });
const order = {
    // addForm
    // selectForms
    // selectFormsByCondition
    // selectForm
    // updFormToChar
    // updFormToCondition
    // delForm
    // delForms

    getAddForm: params => {return http.post('/question/addForm', params)},
    getSelectForms: params => {return http.post('/question/selectForms', params)},
    getSelectFormsByCondition: params => {return http.post('/question/selectFormsByCondition', params)},
    getSelectForm: params => {return http.post('/question/selectForm', params)},
    getUpdFormToChar: params => {return http.post('/question/updFormToChar', params)},
    getUpdFormToCondition: params => {return http.post('/question/updFormToCondition', params)},
    getDelForm: params => {return http.post('/question/delForm', params)},
    getDelForms: params => {return http.post('/question/delForms', params)},

    getSelectSendString: params => {return http.post('/question/selectSendString', params)},
}
export default order
