// MainPage.tsx
import React, { useState, useEffect } from 'react';
import LeftSidebar from './components/LeftSidebar';
import MainContent from './components/MainContent';
import RightSidebar from './components/RightSidebar';
import { UserProfile, Post, HotPost, Board } from '../../types';
import './MainPage.scss';

interface MainPageData {
  userProfile: UserProfile;
  humanitiesPosts: Post[];
  freePosts: Post[];
  hotPosts: HotPost[];
  bestBoards: Board[];
}

const MainPage: React.FC = () => {
  const [data, setData] = useState<MainPageData | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    fetchMainPageData();
  }, []);

  const fetchMainPageData = async () => {
    try {
      // Use relative URL for production (proxied by nginx) or absolute URL for development
      const apiUrl = process.env.REACT_APP_API_URL || 'http://localhost:8080';
      const response = await fetch(`${apiUrl}/api/main/dashboard`, {
        credentials: 'include'
      });

      if (!response.ok) {
        throw new Error('데이터를 불러오는데 실패했습니다.');
      }

      const result = await response.json();
      setData(result);
    } catch (error) {
      console.error('메인 페이지 로딩 실패:', error);
      setError(error instanceof Error ? error.message : '알 수 없는 오류가 발생했습니다.');
    } finally {
      setLoading(false);
    }
  };

  if (loading) {
    return (
      <div className="main-page-container loading">
        <div className="loading-message">로딩 중...</div>
      </div>
    );
  }

  if (error || !data) {
    return (
      <div className="main-page-container error">
        <div className="error-message">
          {error || '데이터를 불러올 수 없습니다.'}
        </div>
      </div>
    );
  }

  return (
    <div className="main-page-container">
      <LeftSidebar userProfile={data.userProfile} />
      <MainContent
        humanitiesPosts={data.humanitiesPosts}
        freePosts={data.freePosts}
      />
      <RightSidebar
        hotPosts={data.hotPosts}
        bestBoards={data.bestBoards}
      />
    </div>
  );
};

export default MainPage;