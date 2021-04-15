// axios.defaults.baseURL = "http://localhost:8086";
import axios from 'axios'
const http = axios.create({ baseURL: 'http://localhost:8086' });
const order = {
    getLogin: params => {return http.post('/user/login', params)},
    getAddData: params => {return http.post('/questionData/addData', params)},
    getSelectNumList: params => {return http.post('/questionData/selectNumList', params)},
    getSelectDatasPlace: params => {return http.post('/questionData/selectDatasPlace', params)},
    getSelectDatas: params => {return http.post('/questionData/selectDatas', params)},
    getUpdData: params => {return http.post('/questionData/updData', params)},
    getUpdDatasColor: params => {return http.post('/questionData/updDatasColor', params)},
    getDelDatasByFormId: params => {return http.post('/questionData/delDatasByFormId', params)},
    getDelDatas: params => {return http.post('/questionData/delDatas', params)},
    getUpdDatasStatus: params => {return http.post('/questionData/updDataStatus', params)},
}
export default order
