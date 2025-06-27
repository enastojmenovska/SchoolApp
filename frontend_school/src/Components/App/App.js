import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import schoolRepository from "../../repository/schoolRepository";
import Subjects from "../Subjects/SubjectsList/subjects";
import SubjectDetails from "../Subjects/SubjectDetails/subjectDetails";
import Header from "../Header/header";
import UserView from "../User/userView";
import BootstrapModal from "../PopUp/BootstrapModal";
import Professors from "../Professors/professorList";
import Literatures from "../Literatures/literaturesList";
import Home from "../Home/homePage";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            subjects: [],
            professors: [],
            literatures: [],
            user: [],
            selectedSubjectForDetails: {},
            showModal: false,
            modalMessage: ''
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Routes>
                            <Route path={"/"} element={<Home/>}/>
                            <Route path={"/subjects"} element={<Subjects subjects={this.state.subjects}
                                                                         showDetails={this.getSubject}
                                                                         chooseSubject={this.chosenSubject}
                                                                         onFilterSubjects={this.filterSubjects}/>}/>
                            <Route path={"/subjects/:id"}
                                   element={<SubjectDetails selectedSubject={this.state.selectedSubjectForDetails}/>}/>
                            <Route path={"/user/chosen-subjects"} element={<UserView user={this.state.user}
                                                                                     onDelete={this.deleteSubject}/>}/>
                            <Route path={"/professors"} element={<Professors professors={this.state.professors}/>}/>
                            <Route path={"/literatures"} element={<Literatures literatures={this.state.literatures}/>}/>
                        </Routes>
                        <BootstrapModal
                            show={this.state.showModal}
                            onHide={this.closeModal}
                            message={this.state.modalMessage}
                        />
                    </div>
                </main>
            </Router>
        )
    }

    componentDidMount() {
        this.fetchData()
    }

    fetchData = () => {
        this.loadSubjects();
        this.loadUser();
        this.loadProfessors();
        this.loadLiteratures();
    }

    loadSubjects = () => {
        schoolRepository.fetchSubjects()
            .then((data) => {
                this.setState({
                    subjects: data.data
                })
            })
    }

    filterSubjects = (name) => {
        schoolRepository.fetchSubjects(name)
            .then((data) => {
                this.setState({
                    subjects: data.data
                })
            })
    }

    loadUser = () => {
        schoolRepository.getUser()
            .then((data) => {
                this.setState({
                    user: data.data
                })
            })
    }

    loadProfessors = () => {
        schoolRepository.fetchProfessors()
            .then((data)=>{
                this.setState({
                    professors: data.data
                })
            })
    }
    loadLiteratures = () => {
        schoolRepository.fetchLiterature()
            .then((data)=>{
                this.setState({
                    literatures: data.data
                })
            })
    }
    getSubject = (id) => {
        schoolRepository.getSubject(id)
            .then((data) => {
                this.setState({
                    selectedSubjectForDetails: data.data
                })
            })
            .catch((error) => {
                console.error("Error fetching subject details:", error);
                this.setState({
                    selectedSubjectForDetails: {} // Ensure the state is not undefined
                });
            });
    }

    chosenSubject = (id) => {
        schoolRepository.addSubject(id)
            .then(() => {
                this.loadUser();
                this.openModal("Subject successfully added!");
            })
    }

    openModal = (message) => {
        this.setState({
            showModal: true,
            modalMessage: message
        });
    }

    closeModal = () => {
        this.setState({
            showModal: false,
            modalMessage: ''
        });
    }

    deleteSubject = (id) => {
        schoolRepository.removeSubject(id)
            .then(() => {
                this.loadUser();
            })
    }

}


export default App;
