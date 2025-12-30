import React from 'react';
import { UserProfile } from '../../../types';
import './LeftSidebar.scss';

interface LeftSidebarProps {
  userProfile: UserProfile;
}

const LeftSidebar: React.FC<LeftSidebarProps> = ({ userProfile }) => {
  return (
    <div className="left-sidebar">
      <div className="user-profile-card">
        <div className="user-avatar">
          {userProfile.avatar ? (
            <img src={userProfile.avatar} alt={userProfile.username} />
          ) : (
            <div className="avatar-placeholder">
              {userProfile.username.charAt(0).toUpperCase()}
            </div>
          )}
        </div>
        <div className="user-info">
          <h3 className="username">{userProfile.nickname || userProfile.username}</h3>
          <p className="email">{userProfile.email}</p>
        </div>
        <div className="user-stats">
          <div className="stat-item">
            <span className="stat-label">게시글</span>
            <span className="stat-value">{userProfile.postCount || 0}</span>
          </div>
          <div className="stat-item">
            <span className="stat-label">댓글</span>
            <span className="stat-value">{userProfile.commentCount || 0}</span>
          </div>
        </div>
        {userProfile.joinDate && (
          <div className="join-date">
            가입일: {new Date(userProfile.joinDate).toLocaleDateString('ko-KR')}
          </div>
        )}
      </div>
    </div>
  );
};

export default LeftSidebar;
