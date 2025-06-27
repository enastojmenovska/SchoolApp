import React from 'react';

const SubjectDetails = (props) => {
    const {selectedSubject} = props;

    if (!selectedSubject || !selectedSubject.literatureList || !selectedSubject.professors) {
        return <div>Loading...</div>; // Show a loading state or message if data is not yet available
    }
    return (
        <div className={"container mm-4 mt-5"}>
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
                        <tr>
                            <td>{props.selectedSubject.name}</td>
                            <td>{props.selectedSubject.description}</td>
                            <td>{props.selectedSubject.numWeeklyClasses}</td>
                            <td>{props.selectedSubject.level}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Literature</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <ul>
                                    {props.selectedSubject.literatureList.map(literature => (
                                        <li key={literature.index}>
                                            <p>{literature.title} by {literature.author}</p>
                                        </li>
                                    ))}
                                </ul>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Professors</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <ul>
                                    {props.selectedSubject.professors.map(professor => (
                                        <li key={professor.index}>
                                            <p>{professor.name} {professor.surname}</p>
                                        </li>
                                    ))}
                                </ul>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    )
}
export default SubjectDetails;