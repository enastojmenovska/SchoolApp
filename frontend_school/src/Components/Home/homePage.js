import React from 'react';
import college_home from '../../images/college_home.jpeg'

const Home = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row justify-content-center align-items-center"}>
                <div className="col text-center">
                    <h1>Welcome to my School Application!</h1>

                    <img style={{height: '300px', width: '400px'}} src={college_home} alt="College Home"/>
                </div>
            </div>
        </div>
    );
}

export default Home;