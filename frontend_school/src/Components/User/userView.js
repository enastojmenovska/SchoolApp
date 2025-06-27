import React from "react";

const UserView = (props) => {
    return (
        <div>
            <div className={"container mm-4 mt-5"}>
                <div className={"row"}>
                    {props.user.subjects.length === 0 ? (
                        <div className={"d-flex justify-content-center align-items-center w-100 h-100"}>
                            <h2>No Selected Subjects!</h2>
                        </div>
                    ) : (
                        <div className={"table-responsive"}>
                            <table className={"table table-striped"}>
                                <thead>
                                <tr>
                                    <th scope={"col"}>Subject Name</th>
                                </tr>
                                </thead>
                                <tbody>
                                {props.user.subjects.map((subject) => (
                                    <tr>
                                        <td>{subject.name}</td>
                                        <td className={"text-right"}>
                                            <a title={"Remove Subject"} className={"btn btn-danger"}
                                               onClick={() => props.onDelete(subject.id)}>
                                                Remove Subject
                                            </a>
                                        </td>
                                    </tr>
                                ))}
                                </tbody>
                            </table>
                        </div>
                    )}
                </div>
            </div>
        </div>
    )
}

export default UserView;