import React from 'react';
import {Link} from 'react-router-dom';

const SubjectTerm = (props) => {
    return (
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.description}</td>
            <td>{props.term.numWeeklyClasses}</td>
            <td>{props.term.level}</td>
            <td className={"text-right"}>
                <Link className={"btn btn-info ml-2"}
                   onClick={() => props.showDetails(props.term.id)}
                    to={`/subjects/${props.term.id}`}>
                    Show Details
                </Link>
                <a title={"Choose Subject"} className={"btn btn-danger"}
                   onClick={() => props.chooseSubject(props.term.id)}>
                    Choose Subject
                </a>
            </td>
        </tr>
    )
}
export default SubjectTerm;