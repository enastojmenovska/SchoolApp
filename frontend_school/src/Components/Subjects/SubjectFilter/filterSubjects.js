import React from 'react';
import {useNavigate} from 'react-router-dom';

const SubjectFilter = (props) => {
    const navigate = useNavigate();
    const [formData, updateFormData] = React.useState({
        name: ""
    })
    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }
    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        props.onFilterSubjects(name);
        navigate("/subjects");
    }

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit} className={"d-flex justify-content-between"}>
                    <div className="form-group flex-grow-1 mr-3 mb-0">
                        <label htmlFor="name"><b>Filter by subject name</b></label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               onChange={handleChange}
                        />
                    </div>
                    <button style={{ height: '40px', marginTop: '20px'}} id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default SubjectFilter;
