import React from "react";

const Literatures = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Title</th>
                            <th scope={"col"}>Author</th>
                            <th scope={"col"}>Publisher</th>
                            <th scope={"col"}>Publication Year</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.literatures.map((term) => {
                            return (
                                <tr>
                                    <td>{term.title}</td>
                                    <td>{term.author}</td>
                                    <td>{term.publisher}</td>
                                    <td>{term.publicationYear}</td>
                                </tr>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default Literatures;