import React from 'react';
import { Modal, Button } from 'react-bootstrap'

const BootstrapModal = ({show, onHide, message}) => (
    <Modal show={show} onHide={onHide}>
        <Modal.Header closeButton>
            <Modal.Title>Notification</Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <p>{message}</p>
        </Modal.Body>
        <Modal.Footer>
            <Button variant="secondary" onClick={onHide}>
                Close
            </Button>
        </Modal.Footer>
    </Modal>
);

export default BootstrapModal;