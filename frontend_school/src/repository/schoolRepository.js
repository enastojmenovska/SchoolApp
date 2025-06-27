import axios from '../custom-axios/axios';

const SchoolService = {
    fetchSubjects: (name) => {
        //return axios.get("/subjects");
        return axios.get("/subjects",{
            params: {
                name: name
            }
        })
    },
    fetchProfessors: () => {
        return axios.get("/professors");
    },
    fetchLiterature: () => {
        return axios.get("/literature");
    },
    getSubject: (id) => {
        return axios.get(`/subjects/${id}`);
    },
    addSubject : (id) => {
        return axios.put(`/user/add-subject/${id}`);
    },
    getUser: () => {
        return axios.get("/user/chosen-subjects");
    },
    removeSubject : (id) => {
        return axios.delete(`/user/delete-subject/${id}`);
    }
}

export default SchoolService;