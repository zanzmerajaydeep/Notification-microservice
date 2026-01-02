import React from 'react'
import { FaEnvelope, FaGithub, FaLinkedin } from 'react-icons/fa'
import { Col, Container, Row } from 'reactstrap'

export const Footer = () => {
    return (
        <div>
        <div style={{ height: "2000px" }}>Content goes here</div>
        <div id="footer" className="sticky-footer">
          <footer className="text-dark py-3">
            <div className="footer-content">
              <Container>
                <Col xs={12} md={6}>
                  <h5>Notifier.com</h5>
                </Col>
              </Container>
              <Container>
                <Col
                  xs={12}
                  md={6}
                  className="d-flex justify-content-center justify-content-md-end"
                >
                  <a>
                    <FaGithub className="mr-3" size={30} />
                  </a>
                  <a>
                    <FaLinkedin className="mr-3" size={30} />
                  </a>
                  <a>
                    <FaEnvelope size={30} />
                  </a>
                </Col>
              </Container>
            </div>
          </footer>
        </div>
      </div>
    )
}
