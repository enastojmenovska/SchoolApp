import React from 'react';
import ReactPaginate from 'react-paginate'
import {Link} from "react-router-dom";
import SubjectTerm from "../SubjectTerm/subjectTerm";
import SubjectFilter from "../SubjectFilter/filterSubjects";

class Subjects extends React.Component{
    constructor(props) {
        super(props);
        this.state ={
            page: 0,
            size: 4
        }
    }

    render() {
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.subjects.length / this.state.size);
        const subjects = this.getSubjectsPage(offset,nextPageOffset);
        console.log(subjects,pageCount)

        return (
            <div className={"container mm-4 mt-5"}>
                <div className={"row"}>
                    <SubjectFilter onFilterSubjects={this.props.onFilterSubjects}/>
                </div>
                <div className={"row"}>
                    <div className={"table-responsive"}>
                        <table className={"table table-striped"}>
                            <thead>
                            <tr>
                                <th scope={"col"}>Name</th>
                                <th scope={"col"}>Description</th>
                                <th scope={"col"}>Weekly Classes</th>
                                <th scope={"col"}>Level</th>
                            </tr>
                            </thead>
                            <tbody>
                            {subjects}
                            </tbody>
                        </table>
                    </div>
                </div>
                <ReactPaginate previousLabel={<button className="btn btn-primary">Back</button>}
                               nextLabel={<button className="btn btn-primary">Next</button>}
                               breakLabel={<a href="/#">...</a>}
                               breakClassName={"break-me"}
                               pageClassName={"ml-1"}
                               pageCount={pageCount}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={5}
                               onPageChange={this.handlePageClick}
                               containerClassName={"pagination m-4 justify-content-center"}
                               activeClassName={"active"}/>
            </div>
        );
    }

    handlePageClick = (data) => {
        let selected = data.selected;
        console.log(selected)
        this.setState({
            page: selected
        })
    }

    getSubjectsPage = (offset, nextPageOffset) => {
        console.log(offset, nextPageOffset)
        return this.props.subjects.map((term, index) => {
            return (
                <SubjectTerm term={term} showDetails={this.props.showDetails} chooseSubject={this.props.chooseSubject}/>
            );
        }).filter((subject, index) => {
            return index >= offset && index < nextPageOffset;
        })
    }
}

export default Subjects;